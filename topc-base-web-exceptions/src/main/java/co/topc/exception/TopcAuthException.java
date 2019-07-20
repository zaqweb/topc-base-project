package co.topc.exception;

/**
 * @author zaqweb
 * @date 2019-07-15 21:38
 */
public class TopcAuthException extends Exception {

  public TopcAuthException() {
    super();
  }

  public TopcAuthException(String message) {
    super(message);
  }

  public TopcAuthException(String message, Throwable cause) {
    super(message, cause);
  }

  public TopcAuthException(Throwable cause) {
    super(cause);
  }
}
