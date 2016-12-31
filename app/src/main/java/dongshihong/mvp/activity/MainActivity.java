package dongshihong.mvp.activity;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import butterknife.Bind;
import com.tbruyelle.rxpermissions.RxPermissions;
import dongshihong.mvp.R;
import dongshihong.mvp.constant.Constant;
import dongshihong.mvp.fragment.AboutMeFragemnt;
import dongshihong.mvp.fragment.ImageViewPagerFragment;
import dongshihong.mvp.fragment.JokeMainPagerFragment;
import dongshihong.mvp.fragment.NewsViewPagerFragment;
import dongshihong.mvp.mvp.view.View.BaseView;
import dongshihong.mvp.utils.ActivityCollector;
import rx.Subscriber;

/**
 * Created by Dsh on 2016/11/30
 */

public class MainActivity extends BaseActivity implements BaseView.MainView {
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.nav_view) NavigationView mNavigationView;
  @Bind(R.id.drawer_layout) DrawerLayout drawerLayout;
  @Bind(R.id.frame) FrameLayout frame;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getAllPermission();
    init();
  }

  private void init() {
    mToolbar.setTitle("新闻列表");
    setSupportActionBar(mToolbar);
    setupDrawerContent(mNavigationView);
    switchNews();
  }

  private void getAllPermission() {
    RxPermissions.getInstance(this)
        .request(Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE)
        .subscribe(new Subscriber<Boolean>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {

          }

          @Override public void onNext(Boolean aBoolean) {
            if (aBoolean) {

            } else {
              ToastShow("权限不够");
            }
          }
        });
  }

  private void setupDrawerContent(NavigationView navigationView) {
    navigationView.setNavigationItemSelectedListener(
        new NavigationView.OnNavigationItemSelectedListener() {
          @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            item.setChecked(true);
            mToolbar.setTitle(item.getTitle());
            if (item.getItemId() == R.id.nav_camera) {
              switchNews();
            } else if (item.getItemId() == R.id.nav_gallery) {
              switchImageClassification();
            } else if (item.getItemId() == R.id.nav_manage) {
              switchJoke();
            } else if (item.getItemId() == R.id.shuoming) {
              switchAbout();
            }
            drawerLayout.closeDrawers();
            return true;
          }
        });
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_main;
  }

  @Override public void onBackPressed() {
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
      drawerLayout.closeDrawer(GravityCompat.START);
    } else {
      if (Constant.BACK_EXIT) {
        super.onBackPressed();
        ActivityCollector.removeAllActivity();
        return;
      }
      Constant.BACK_EXIT = true;
      ToastShow("再按一次退出");
      new Handler().postDelayed(new Runnable() {
        @Override public void run() {
          Constant.BACK_EXIT = false;
        }
      }, 2000);
    }
  }

  @Override public void switchNews() {
    replaceFragment(new NewsViewPagerFragment());
  }

  @Override public void switchImageClassification() {
    replaceFragment(new ImageViewPagerFragment());
  }

  @Override public void switchNewImage() {

  }

  @Override public void switchJoke() {
    replaceFragment(new JokeMainPagerFragment());
  }

  @Override public void switchAbout() {
    replaceFragment(new AboutMeFragemnt());
  }

  public void replaceFragment(Fragment fragment) {
    getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
  }
}
