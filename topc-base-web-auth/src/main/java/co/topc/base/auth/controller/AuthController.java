package co.topc.base.auth.controller;

import co.topc.base.auth.util.AuthConstant;
import co.topc.base.auth.util.JWTUtil;
import co.topc.base.auth.util.TopcMD5Util;
import co.topc.base.auth.config.shiro.BasicLoginParam;
import co.topc.web.commons.TopcWebResponse;
import co.topc.web.commons.constants.TopcWebResponseEnum;
import co.topc.web.commons.utils.TopcWebResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


/**
 * @author zaqweb
 * @date 2019-07-29 23:28
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("login")
    public TopcWebResponse loginBasic(BasicLoginParam loginParam, HttpServletResponse response) {
        loginParam.setPassword(TopcMD5Util.encrypt(loginParam.getPassword()));
        Subject sub = SecurityUtils.getSubject();
        String topcToken="";
        try {
            sub.login(loginParam);
            topcToken = JWTUtil.sign(sub.getPrincipal().toString(), "Topc000001", loginParam.getPassword());
            response.setHeader(AuthConstant.AUTHENTICATE_HEADER, topcToken);
        } catch (UnknownAccountException ue) {
            return TopcWebResponseUtil.getFailResult(TopcWebResponseEnum.UNKNOWNACCOUNT.getCode(),
                                                TopcWebResponseEnum.UNKNOWNACCOUNT.getMessage(), "");
        } catch (Exception e) {

        }
        return TopcWebResponseUtil.getSuccess(topcToken);
    }

    @RequestMapping("smsLogin")
    public TopcWebResponse smsLogin() {

        return TopcWebResponseUtil.getSuccess("ok");
    }

    @RequestMapping("wechatLogin")
    public TopcWebResponse wechatLogin() {
        return null;
    }

    @RequestMapping("aliLogin")
    public TopcWebResponse aliLogin() {
        return null;
    }
}
