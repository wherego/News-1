package dongshihong.mvp.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import butterknife.ButterKnife;
import dongshihong.mvp.utils.ActivityCollector;
import dongshihong.mvp.utils.RxUtils;

/**
 * Created by Dsh on 2016/11/30
 */

public abstract class BaseActivity extends AppCompatActivity {

  private static Context context;
  private static Activity activity;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    context = getApplicationContext();
    activity = this;
    setContentView(getLayoutId());
    ButterKnife.bind(this);
    ActivityCollector.addActivity(this);
  }

  public void ToastShow(String str) {
    Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
  }

  protected abstract int getLayoutId();

  public static Context getContext() {
    return context;
  }

  public static Activity getActivity() {
    return activity;
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    RxUtils.unsubscribe();
    ButterKnife.unbind(this);
    ActivityCollector.removeActivity(getActivity());
    //activity = null;
  }
}
