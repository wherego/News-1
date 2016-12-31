package dongshihong.mvp.application;

import android.app.Application;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Dsh on 2016/12/2
 */

public class MyApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    LeakCanary.install(this);
  }
}
