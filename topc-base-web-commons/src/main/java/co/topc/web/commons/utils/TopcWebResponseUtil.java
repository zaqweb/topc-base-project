package co.topc.web.commons.utils;

import co.topc.web.commons.constants.TopcWebResponseEnum;
import co.topc.web.commons.TopcWebResponse;

/**
 * @author zaqweb
 * @date 2019-07-01 22:09
 */
public final class TopcWebResponseUtil {

  public static TopcWebResponse getSuccess() {

    return new TopcWebResponse(
        TopcWebResponseEnum.SUCCESS.getCode(), TopcWebResponseEnum.SUCCESS.getMessage(), "");
  }

  public static TopcWebResponse getSuccess(Object data) {
    return new TopcWebResponse(
        TopcWebResponseEnum.SUCCESS.getCode(), TopcWebResponseEnum.SUCCESS.getMessage(), data);
  }

  public static TopcWebResponse getFaile() {

    return new TopcWebResponse(
        TopcWebResponseEnum.FAILURE.getCode(), TopcWebResponseEnum.FAILURE.getMessage(), "");
  }

  public static TopcWebResponse getFaileNotFound() {

    return new TopcWebResponse(
            TopcWebResponseEnum.FAILURE_NOT_FOUND.getCode(), TopcWebResponseEnum.FAILURE_NOT_FOUND.getMessage(), "");
  }

  public static TopcWebResponse getFailResult(String  resultCode,String message,Object data){
    TopcWebResponse resultInfo = new TopcWebResponse(resultCode,message,data);
    return  resultInfo;
  }
}
