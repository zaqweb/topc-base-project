package co.topc.base.auth.util;

import co.topc.base.auth.config.AuthProperties;
import co.topc.web.commons.utils.TopcStringUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author fantao
 */
public class JWTUtil {

    private static Logger logger = LoggerFactory.getLogger(JWTUtil.class);

    private static final long EXPIRE_TIME = SpringContextUtil.getBean(AuthProperties.class).getShiro().getJwtTimeOut() * 1000;

    /**
     * 校验 token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            verifier.verify(token);
            logger.info("token is valid");
            return true;
        } catch (Exception e) {
            logger.info("token is invalid{}", e.getMessage());
            return false;
        }
    }

    /**
     * 从 token中获取用户名
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            logger.error("error：{}", e.getMessage());
            return null;
        }
    }

    /**
     * 生成 token
     *
     * @param pricipal 用户身份
     * @param secret   用户的密码
     * @return token
     */
    public static String sign(String pricipal, String lesseeId, String secret) {
        try {
            String username = TopcStringUtils.lowerCase(pricipal);
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withClaim("userName", username)
                    .withClaim("lesseeId", lesseeId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            logger.error("error：{}", e);
            return null;
        }
    }

    /**
     * 判断token是否已经失效
     */
    public static boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     */
    private static Date getExpiredDateFromToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt();
    }
}
