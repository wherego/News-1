package dongshihong.mvp.utils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import dongshihong.mvp.R;
import java.io.File;

/**
 * Created by Dsh on 2016/12/14
 */

public class ActivityUtils {

  public static void startActivity(Class<?> cla, Bundle bundle) {
    Intent intent = new Intent(UIUtils.getContext(), cla);
    intent.putExtras(bundle);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    UIUtils.getContext().startActivity(intent);
  }

  public static void share(String message) {
    Intent intent = new Intent(Intent.ACTION_SEND);
    intent.setType("text/plain");
    intent.putExtra(Intent.EXTRA_TEXT, message);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    UIUtils.getActivity()
        .startActivity(Intent.createChooser(intent, UIUtils.getString(R.string.share)));
  }

  //获取图库路径
  public static File ImagePath() {
    String sdcard = Environment.getExternalStorageDirectory().toString();
    File file = new File(sdcard + "/DCIM");
    if (!file.exists()) {
      file.mkdirs();
    }
    File mFile = new File(file + "/MvpDemo");
    if (!mFile.exists()) {
      mFile.mkdirs();
    }
    return mFile.getAbsoluteFile();
  }
}
