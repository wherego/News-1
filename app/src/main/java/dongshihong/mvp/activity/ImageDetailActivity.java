package dongshihong.mvp.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import butterknife.Bind;
import com.tbruyelle.rxpermissions.RxPermissions;
import dongshihong.mvp.R;
import dongshihong.mvp.adapter.ImageViewPagerAdapter;
import dongshihong.mvp.mvp.view.BasePresenter.BasePresenter;
import dongshihong.mvp.mvp.view.Bean.ImageDetailBean;
import dongshihong.mvp.mvp.view.View.BaseView;
import dongshihong.mvp.mvp.view.presenter.ImageDetilsDataImpl;
import dongshihong.mvp.utils.ActivityUtils;
import dongshihong.mvp.utils.UIUtils;
import java.util.ArrayList;
import java.util.List;
import rx.Subscriber;

/**
 * Created by Dsh on 2016/12/15
 */

public class ImageDetailActivity extends BaseActivity implements BaseView.ImageDetils {

  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.viewPager) ViewPager mViewPager;
  private int id;
  private String title;
  private BasePresenter.ImageDetilsPresenter mImageDetilsPresenter;
  private ImageViewPagerAdapter mImageViewPagerAdapter;
  private List<ImageDetailBean> mImageDetailBeen = new ArrayList<>();

  @Override protected int getLayoutId() {
    return R.layout.activity_imagedetils;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initToolbar();
    getPermission();
    getBundle();
    initData();
  }

  private void initData() {
    mImageDetilsPresenter = new ImageDetilsDataImpl(this);
    mImageDetilsPresenter.requestNetWork(id, null);
  }

  private void initToolbar() {
    mToolbar.setTitle("图片详情");
    setSupportActionBar(mToolbar);
  }

  public static void startIntent(int id, String title) {
    Bundle bundle = new Bundle();
    bundle.putInt("id", id);
    bundle.putString("title", title);
    ActivityUtils.startActivity(ImageDetailActivity.class, bundle);
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.toolbar_menus, menu);
    return true;
  }

  public void getBundle() {
    Bundle bundle = getIntent().getExtras();
    if (bundle != null && !bundle.isEmpty()) {
      id = bundle.getInt("id");
      title = bundle.getString("title");
    }
  }

  public void getPermission() {
    RxPermissions.getInstance(UIUtils.getActivity())
        .request(Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS,
            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
        .subscribe(new Subscriber<Boolean>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {
            ToastShow("权限有问题");
          }

          @Override public void onNext(Boolean aBoolean) {

          }
        });
  }

  @Override public void setData(List<ImageDetailBean> datas) {
    if (datas.size() > 0) {
      mImageDetailBeen.clear();
      mImageDetailBeen.addAll(datas);
      mImageViewPagerAdapter = new ImageViewPagerAdapter(mImageDetailBeen, getActivity());
      mViewPager.setAdapter(mImageViewPagerAdapter);
    }
  }

  @Override public void netWorkError() {
    ToastShow("请求失败");
  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    mImageDetilsPresenter.competence(requestCode, grantResults);
  }
}
