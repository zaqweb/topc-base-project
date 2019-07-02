package co.topc.web.commons.constants;

/**
 * @author zaqweb
 * @date 2019-07-01 22:12
 */
public enum TopcWebResponseEnum {

    SUCCESS("000000", "成功"),
    UNAUTHORIZED("401000", "未经授权的请求"),
    SERVER_INTERNAL_ERROR("500000", "系统内部异常"),
    FAILURE("999000", "请求失败"),
    FAILURE_NOT_FOUND("999404", "没有符合条件的数据");

    TopcWebResponseEnum (String code,String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
