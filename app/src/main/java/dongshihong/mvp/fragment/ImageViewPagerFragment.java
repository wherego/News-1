package dongshihong.mvp.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import dongshihong.mvp.R;
import dongshihong.mvp.adapter.TabNewsAdapter;
import dongshihong.mvp.mvp.view.Bean.Tngou;
import dongshihong.mvp.mvp.view.View.BaseView;
import dongshihong.mvp.mvp.view.presenter.TabNamePresenter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dsh on 2016/12/9
 */

public class ImageViewPagerFragment extends BaseFragment implements BaseView.TabNewsView {
  private View view;
  private TabLayout mTabLayout;
  private ViewPager mViewPager;
  private TabNamePresenter mTabNamePresenter;
  private List<Tngou> mTngouList = new ArrayList<>();
  private TabNewsAdapter tabNewsAdapter;


  @Override protected void initData() {
    mTabNamePresenter = new TabNamePresenter(this);
    mTabNamePresenter.requestNetWork();
  }

  @Override protected View initView() {
    view = View.inflate(getActivity(), R.layout.fragment_viewpager, null);
    mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
    mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
    mTabLayout.setupWithViewPager(mViewPager);
    tabNewsAdapter = new TabNewsAdapter(getChildFragmentManager(), mTngouList, 2);
    mViewPager.setAdapter(tabNewsAdapter);
    return view;
  }

  @Override public void setData(List<Tngou> datas) {
    if (datas.size() > 0) {
      mTngouList.addAll(datas);
      tabNewsAdapter.notifyDataSetChanged();
      mViewPager.setOffscreenPageLimit(datas.size());
    }
  }

  @Override public void netWorkError() {

  }

  @Override public void onDestroy() {
    super.onDestroy();
    view=null;
  }
}
