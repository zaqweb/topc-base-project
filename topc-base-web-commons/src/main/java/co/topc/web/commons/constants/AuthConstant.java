package co.topc.web.commons.constants;

/**
 * @author fantao
 * @date 2019/7/11 20:36
 */
public class AuthConstant {

    /**
     * 用户状态：有效
     */
    public static final String STATUS_VALID = "1";
    /**
     * 用户状态：锁定
     */
    public static final String STATUS_LOCK = "0";
    /**
     * 默认头像
     */
    public static final String DEFAULT_AVATAR = "default.jpg";
    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "1234qwer";
    /**
     * 性别男
     */
    public static final String SEX_MALE = "0";
    /**
     * 性别女
     */
    public static final String SEX_FEMALE = "1";
    /**
     * 性别保密
     */
    public static final String SEX_UNKNOW = "2";
    /**
     * 黑色主题
     */
    public static final String THEME_BLACK = "black";
    /**
     * 白色主题
     */
    public static final String THEME_WHITE = "white";
    /**
     * TAB开启
     */
    public static final String TAB_OPEN = "1";
    /**
     * TAB关闭
     */
    public static final String TAB_CLOSE = "0";

    public static final String COMMA = ",";

    /**
     * user缓存前缀
     */
    public static final String USER_CACHE_PREFIX = "auth.cache.user.";
    /**
     * user角色缓存前缀
     */
    public static final String USER_ROLE_CACHE_PREFIX = "auth.cache.user.role.";
    /**
     * user权限缓存前缀
     */
    public static final String USER_PERMISSION_CACHE_PREFIX = "auth.cache.user.permission.";
    /**
     * user个性化配置前缀
     */
    public static final String USER_CONFIG_CACHE_PREFIX = "auth.cache.user.config.";
    /**
     * token缓存前缀
     */
    public static final String TOKEN_CACHE_PREFIX = "auth.cache.token.";

    /**
     * 存储在线用户的 zset前缀
     */
    public static final String ACTIVE_USERS_ZSET_PREFIX = "auth.user.active";

    /**
     * 排序规则： descend 降序
     */
    public static final String ORDER_DESC = "descend";
    /**
     * 排序规则： ascend 升序
     */
    public static final String ORDER_ASC = "ascend";

    /**
     * 按钮
     */
    public static final String TYPE_BUTTON = "1";
    /**
     * 菜单
     */
    public static final String TYPE_MENU = "0";

    /**
     * 网络资源 Url
     */
    public static final String MEIZU_WEATHER_URL = "http://aider.meizu.com/app/weather/listWeather";
    public static final String MRYW_TODAY_URL = "https://interface.meiriyiwen.com/article/today";
    public static final String MRYW_DAY_URL = "https://interface.meiriyiwen.com/article/day";
    public static final String TIME_MOVIE_HOT_URL = "https://api-m.mtime.cn/Showtime/LocationMovies.api";
    public static final String TIME_MOVIE_DETAIL_URL = "https://ticket-api-m.mtime.cn/movie/detail.api";
    public static final String TIME_MOVIE_COMING_URL = "https://api-m.mtime.cn/Movie/MovieComingNew.api";
    public static final String TIME_MOVIE_COMMENTS_URL = "https://ticket-api-m.mtime.cn/movie/hotComment.api";


}
