package co.topc.base.auth.config.shiro;

import co.topc.base.auth.config.shiro.BasicLoginParam;

/**
 * @author zaqweb
 * @date 2019-07-29 23:44
 */
public class SmsLoginParam extends BasicLoginParam {

    /**
     * 手机号
     */
    String phone;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
