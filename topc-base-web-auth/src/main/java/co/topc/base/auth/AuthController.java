package co.topc.base.auth;

import co.topc.base.auth.authentication.JWTUtil;
import co.topc.base.auth.common.util.TopcAuthUtil;
import co.topc.base.auth.common.util.TopcMD5Util;
import co.topc.base.auth.shiro.BasicLoginParam;
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
//            topcToken = TopcAuthUtil.encryptToken(JWTUtil.sign(sub.getPrincipal().toString(), loginParam.getPassword()));
            response.setHeader(AuthConstant.AUTHENTICATE_HEADER, topcToken);
        } catch (UnknownAccountException ue) {
            return TopcWebResponseUtil.getFailResult(TopcWebResponseEnum.UNKNOWNACCOUNT.getCode(),
                                                TopcWebResponseEnum.UNKNOWNACCOUNT.getMessage(), "");
        } catch (Exception e) {

        }
        return TopcWebResponseUtil.getSuccess(topcToken);
    }

  public static void main(String[] args) {
    String ss = "300c3192c586d19ff8a5f479b7d2337604160dcccb2e891c500d4b3555d415582ccc7b1d8739047316f1419e6ab63412e2b994e7c54271fb776ba51d5acd4b91453bce2a95d70b6b04fffbc321013174a5fd94bbc005990c468dc19bd42ca36e343b8d52560348153c50f9f470f85b421a1283d66c85cd5858aaca5c8b163994f7ec10f6ac9173e7";

    System.out.println(TopcAuthUtil.decryptToken(ss));

  }

    @RequestMapping("smsLogin")
    public TopcWebResponse smsLogin() {

        return null;
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
