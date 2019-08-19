package co.topc.base.auth.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.MergableAuthenticationInfo;
import org.apache.shiro.subject.MutablePrincipalCollection;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zaqweb
 * @date 2019-07-30 23:26
 */
public class TopcAuthInfo implements MergableAuthenticationInfo {

    protected PrincipalCollection principals;

    protected Object credentials;

    protected String lesseeId;

    protected Object principal;

    public TopcAuthInfo(Object principal, String realmName) {
        this.principals = new SimplePrincipalCollection(principal, realmName);
    }

    @Override
    public PrincipalCollection getPrincipals() {
        return this.principals;
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    public void setCredentials(Object credentials) {
        this.credentials = credentials;
    }

    public void setPrincipals(PrincipalCollection principals) {
        this.principals = principals;
    }

    public String getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(String lesseeId) {
        this.lesseeId = lesseeId;
    }

    public Object getPrincipal() {
        return principal;
    }

    public void setPrincipal(Object principal) {
        this.principal = principal;
    }

    @Override
    public void merge(AuthenticationInfo authenticationInfo) {
        if (authenticationInfo != null && authenticationInfo.getPrincipals() != null && !authenticationInfo.getPrincipals().isEmpty()) {
            if (this.principals == null) {
                this.principals = authenticationInfo.getPrincipals();
            } else {
                if (!(this.principals instanceof MutablePrincipalCollection)) {
                    this.principals = new SimplePrincipalCollection(this.principals);
                }

                ((MutablePrincipalCollection)this.principals).addAll(authenticationInfo.getPrincipals());
            }

            Object thisCredentials = this.getCredentials();
            Object otherCredentials = authenticationInfo.getCredentials();
            if (otherCredentials != null) {
                if (thisCredentials == null) {
                    this.credentials = otherCredentials;
                } else {
                    if (!(thisCredentials instanceof Collection)) {
                        Set newSet = new HashSet();
                        newSet.add(thisCredentials);
                        this.setCredentials(newSet);
                    }

                    Collection credentialCollection = (Collection)this.getCredentials();
                    if (otherCredentials instanceof Collection) {
                        credentialCollection.addAll((Collection)otherCredentials);
                    } else {
                        credentialCollection.add(otherCredentials);
                    }

                }
            }
        }
    }
}
