package co.topc.web.commons;

import java.io.Serializable;

/**
 * web项目响应实体
 *
 * @author zaqweb
 * @date 2019-06-30 15:42
 */
public final class TopcWebResponse implements Serializable {

  /** 响应码，仅000000表示成功 */
  private String code;
  /** 响应说明 */
  private String message;

  /** 响应数据 */
  private Object data;

  public TopcWebResponse(String code, String message, Object data) {
      this.code = code;
      this.message = message;
      this.data = data;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
