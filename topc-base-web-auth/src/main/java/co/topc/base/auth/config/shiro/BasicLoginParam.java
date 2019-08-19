package co.topc.base.auth.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;

import javax.validation.constraints.NotBlank;

/**
 * @author zaqweb
 * @date 2019-07-29 23:43
 */
public class BasicLoginParam implements AuthenticationToken {

    /**
     * 用户名
     */
    @NotBlank(message = "登录用户明不能为空")
    private String username;

    /**
     * 用户密码
     */
    @NotBlank(message = "登录密码不能为空")
    private String password;

    /**
     * 登陆验证码
     */
    private String vCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getvCode() {
        return vCode;
    }

    public void setvCode(String vCode) {
        this.vCode = vCode;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredentials() {
        return password;
    }
}
