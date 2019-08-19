package co.topc.base.auth.config.shiro;

import co.topc.base.auth.entity.User;
import co.topc.base.auth.service.IUserService;
import co.topc.web.commons.constants.TopcWebResponseEnum;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zaqweb
 * @date 2019-07-29 23:41
 */
public class BasicRealm extends AuthenticatingRealm {

    private static String realmName = "basicRealm";

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IUserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof BasicLoginParam;
    }

    @Override
    public Class getAuthenticationTokenClass() {
        return super.getAuthenticationTokenClass();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        BasicLoginParam param = (BasicLoginParam) authenticationToken;

        try {
            User user = userService.findByUserNamePassword(param.getUsername(),param.getPassword());
            if (null == user) {
                throw new UnknownAccountException(TopcWebResponseEnum.UNKNOWNACCOUNT.getMessage());
            }
            TopcAuthInfo authenticateInfo = new TopcAuthInfo(user.getUserName(), getRealmName());
            authenticateInfo.setPrincipal(user.getUserId());
            authenticateInfo.setLesseeId(user.getLesseeId());
            authenticateInfo.setCredentials(user.getPassword());
            return authenticateInfo;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new UnknownAccountException(e.getMessage(), e);
        }


    }


    private static String getRealmName() {
        return realmName;
    }

}
