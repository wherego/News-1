package dongshihong.mvp.utils;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dsh on 2016/11/30
 */

public class ActivityCollector {
  private static final List<Activity> list = new ArrayList<>();

  public static void addActivity(Activity activity) {
    list.add(activity);
  }

  public static void removeActivity(Activity activity) {
    list.remove(activity);
  }

  public static void removeAllActivity() {
    for (Activity activity : list) {
      if (!activity.isFinishing()) {
        activity.finish();
      }
    }
  }
}
