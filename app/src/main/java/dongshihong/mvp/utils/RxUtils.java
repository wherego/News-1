package dongshihong.mvp.utils;

import rx.Subscription;

/**
 * Created by Dsh on 2016/11/30
 */

public class RxUtils {
  public static Subscription subscription;
  public static void unsubscribe(){
    if(subscription!=null&&!subscription.isUnsubscribed()){
      subscription.unsubscribe();
    }
  }
}
