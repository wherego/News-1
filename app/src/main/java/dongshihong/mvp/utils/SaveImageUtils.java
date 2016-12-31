package dongshihong.mvp.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Dsh on 2016/12/27
 */

public class SaveImageUtils {
  public static void saveImageView(final ImageView imageView, final int id) {
    RxUtils.subscription = Observable.just(imageView)
        .map(new Func1<ImageView, String>() {
          @Override public String call(ImageView imageView) {
            File file = new File(ActivityUtils.ImagePath(), id + ".jpg");
            FileOutputStream output = null;
            try {
              output = new FileOutputStream(file);
              Bitmap image = imageView.getDrawingCache();
              image.compress(Bitmap.CompressFormat.JPEG, 100, output);
              output.flush();
              output.close();
              return "true";
            } catch (Exception e) {
              e.printStackTrace();
            }
            return "false";
          }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<String>() {
          @Override public void call(String s) {
            if (s.equals("true")) {
              Toast.makeText(UIUtils.getContext(), "保存成功", Toast.LENGTH_SHORT).show();
            } else {
              Toast.makeText(UIUtils.getContext(), "保存失败", Toast.LENGTH_SHORT).show();
            }
          }
        }, new ErrorResponse() {
          @Override public void ErrorResponse(String str) {
            Toast.makeText(UIUtils.getContext(), "错误:" + str, Toast.LENGTH_SHORT).show();
          }
        });
  }
}
