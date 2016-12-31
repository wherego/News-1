package dongshihong.mvp.utils;

import rx.functions.Action1;

/**
 * Created by Dsh on 2016/12/27
 */

public abstract class ErrorResponse implements Action1<Throwable> {
  @Override public void call(Throwable throwable) {
    ErrorResponse(throwable.toString());
  }
  public abstract void ErrorResponse(String str);
}
