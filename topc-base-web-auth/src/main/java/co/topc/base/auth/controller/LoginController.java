package co.topc.base.auth.controller;

import co.topc.base.auth.authentication.JWTToken;
import co.topc.base.auth.authentication.JWTUtil;
import co.topc.base.auth.common.util.TopcAuthUtil;
import co.topc.base.auth.common.util.TopcMD5Util;
import co.topc.base.auth.entity.User;
import co.topc.base.auth.properties.AuthProperties;
import co.topc.base.auth.service.IUserService;
import co.topc.base.auth.service.UserManager;
import co.topc.web.commons.TopcWebResponse;
import co.topc.web.commons.utils.TopcDateUtils;
import co.topc.web.commons.utils.TopcWebResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Validated
@RestController
public class LoginController {

    @Autowired
    private UserManager userManager;
    @Autowired
    private IUserService userService;
    @Autowired
    private AuthProperties properties;
    @Autowired
    private ObjectMapper mapper;

    @PostMapping("/login")
    public TopcWebResponse login(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password, HttpServletRequest request) throws Exception {
        username = StringUtils.lowerCase(username);
        password = TopcMD5Util.encrypt(username, password);


        final String errorMessage = "用户名或密码错误";
        User user = this.userManager.getUser(username);

        if (user == null) {
            throw new Exception(errorMessage);
        }
        if (!StringUtils.equals(user.getPassword(), password)) {
            throw new Exception(errorMessage);
        }
        if (User.STATUS_LOCK.equals(user.getStatus())) {
            throw new Exception("账号已被锁定,请联系管理员！");
        }

        // 更新用户登录时间
//        this.userService.updateLoginTime(username);

        String token = TopcAuthUtil.encryptToken(JWTUtil.sign(username, password));
        LocalDateTime expireTime = LocalDateTime.now().plusSeconds(properties.getShiro().getJwtTimeOut());
        String expireTimeStr = TopcDateUtils.formatFullTime(expireTime);
        JWTToken jwtToken = new JWTToken(token, expireTimeStr);

//        String userId = this.saveTokenToRedis(user, jwtToken, request);
//        user.setId(userId);

        Map<String, Object> userInfo = this.generateUserInfo(jwtToken, user);

        TopcWebResponse topcWebResponse = TopcWebResponseUtil.getSuccess();
        topcWebResponse.setMessage("认证成功");
        topcWebResponse.setData(userInfo);
        return topcWebResponse;
    }

    @PostMapping("regist")
    public void regist(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password) throws Exception {
        this.userService.regist(username, password);
    }


    /**
     * 生成前端需要的用户信息，包括：
     * 1. token
     * 2. Vue Router
     * 3. 用户角色
     * 4. 用户权限
     * 5. 前端系统个性化配置信息
     *
     * @param token token
     * @param user  用户信息
     * @return UserInfo
     */
    private Map<String, Object> generateUserInfo(JWTToken token, User user) {
        String username = user.getUserName();
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("token", token.getToken());
        userInfo.put("exipreTime", token.getExipreAt());

        Set<String> roles = this.userManager.getUserRoles(username);
        userInfo.put("roles", roles);

        Set<String> permissions = this.userManager.getUserPermissions(username);
        userInfo.put("permissions", permissions);

//        UserConfig userConfig = this.userManager.getUserConfig(String.valueOf(user.getUserId()));
//        userInfo.put("config", userConfig);

        user.setPassword("it's a secret");
        userInfo.put("user", user);
        return userInfo;
    }

    public static void main(String[] args) {
        String password = TopcMD5Util.encrypt("scott", "fantao123");
        System.out.println(password);

    }
}
