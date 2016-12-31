package dongshihong.mvp.network;

import rx.Subscriber;

/**
 * Created by Dsh on 2016/12/1
 */

public class MySubscriber<T> extends Subscriber<T> {

  @Override public void onStart() {
    super.onStart();
  }

  @Override public void onCompleted() {
  }

  @Override public void onError(Throwable e) {

  }

  @Override public void onNext(T t) {
  }
}
