package dongshihong.mvp.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Bind;
import dongshihong.mvp.R;
import dongshihong.mvp.adapter.TabNewsAdapter;
import dongshihong.mvp.mvp.view.BasePresenter.BasePresenter;
import dongshihong.mvp.mvp.view.Bean.Tngou;
import dongshihong.mvp.mvp.view.View.BaseView;
import dongshihong.mvp.mvp.view.presenter.TabNewsPresenter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dsh on 2016/11/30
 */

public class NewsViewPagerFragment extends BaseFragment implements BaseView.TabNewsView {
  private View view;
  @Bind(R.id.viewPager) ViewPager mViewPager;
  @Bind(R.id.tab_layout) TabLayout mTabLayout;
  private List<Tngou> data;
  private TabNewsAdapter tabNewsAdapter;

  @Override protected void initData() {
    mTabLayout.setupWithViewPager(mViewPager);
    data = new LinkedList<>();
    tabNewsAdapter = new TabNewsAdapter(getChildFragmentManager(), data, 1);
    BasePresenter.TabNewsPresenter tabNewsPresenter = new TabNewsPresenter(this);
    tabNewsPresenter.requestNetWork();
  }

  @Override protected View initView() {
    view = View.inflate(getActivity(), R.layout.fragment_viewpager, null);
    return view;
  }

  @Override public void setData(List<Tngou> datas) {
    if (datas.size() > 0) {
      data.addAll(datas);
      mViewPager.setAdapter(tabNewsAdapter);
      tabNewsAdapter.notifyDataSetChanged();
      mViewPager.setOffscreenPageLimit(datas.size());
    }
  }

  @Override public void netWorkError() {
    ToastShow("网络错误");
  }

  @Override public void onDestroy() {
    super.onDestroy();
    view = null;
  }
}
