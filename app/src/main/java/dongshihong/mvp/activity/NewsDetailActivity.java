package dongshihong.mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Bind;
import com.bumptech.glide.Glide;
import dongshihong.mvp.R;
import dongshihong.mvp.mvp.view.Bean.NewsDetilsBean;
import dongshihong.mvp.mvp.view.View.BaseView;
import dongshihong.mvp.mvp.view.presenter.NewsDetilsPresenterImpl;
import dongshihong.mvp.mvp.view.presenter.ToolbarSharePresenterImpl;
import dongshihong.mvp.network.Api;
import dongshihong.mvp.utils.ActivityUtils;
import dongshihong.mvp.utils.UIUtils;

/**
 * Created by Dsh on 2016/12/14
 */

public class NewsDetailActivity extends BaseActivity
    implements BaseView.DetailContent, BaseView.showShare {
  @Bind(R.id.image) ImageView mImageView;
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.progressBar) ProgressBar mProgressBar;
  @Bind(R.id.content) TextView mTextView;
  @Bind(R.id.collapsing_toolbar) CollapsingToolbarLayout mCollapsingToolbarLayout;
  private int id;
  private NewsDetilsPresenterImpl mNewsDetilsPresenter;
  private String message;
  private ToolbarSharePresenterImpl mShowShare;

  @Override protected int getLayoutId() {
    return R.layout.activity_newsdetail;
  }

  public static void startIntent(int id) {
    Bundle bundle = new Bundle();
    bundle.putInt("id", id);
    ActivityUtils.startActivity(NewsDetailActivity.class, bundle);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setSupportActionBar(mToolbar);
    getBundle();
    initData();
  }

  private void initData() {
    mShowShare = new ToolbarSharePresenterImpl(this);
    mNewsDetilsPresenter = new NewsDetilsPresenterImpl(this);
    mNewsDetilsPresenter.requestNetWork(id);

    mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
      @Override public boolean onMenuItemClick(MenuItem item) {
        mShowShare.switchId(item.getItemId());
        return true;
      }
    });
  }

  public void getBundle() {
    Bundle bundle = getIntent().getExtras();
    if (bundle != null && !bundle.isEmpty()) {
      id = bundle.getInt("id");
    }
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.toolbar_menus, menu);
    return true;
  }

  @Override public void setData(NewsDetilsBean newsDetilsBean) {
    if (newsDetilsBean != null && !newsDetilsBean.equals("")) {
      Glide.with(UIUtils.getActivity())
          .load(Api.IMAGER_URL + newsDetilsBean.getImg())
          .centerCrop()
          .into(mImageView);
      mTextView.setText(Html.fromHtml(newsDetilsBean.getMessage()));
      mCollapsingToolbarLayout.setTitle(newsDetilsBean.getTitle());
      message = String.valueOf(Html.fromHtml(newsDetilsBean.getMessage()));
    }
  }

  @Override public void error() {
    ToastShow("请求失败");
  }

  @Override public void hideProgress() {
    mProgressBar.setVisibility(View.GONE);
  }

  @Override public void showPregress() {

  }

  @Override public void switchShare() {
    ActivityUtils.share(message);
  }

}
