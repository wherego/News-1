package dongshihong.mvp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import dongshihong.mvp.R;
import dongshihong.mvp.adapter.RecyclerViewAdapter;
import dongshihong.mvp.mvp.view.Bean.tnogo;
import dongshihong.mvp.mvp.view.View.BaseView;
import dongshihong.mvp.mvp.view.presenter.newsListPresenterImpl;
import java.util.List;

/**
 * Created by Dsh on 2016/11/30
 */

public class NewsMainFragment extends BaseFragment
    implements BaseView.NewsListView, PullLoadMoreRecyclerView.PullLoadMoreListener,
    RecyclerViewAdapter.OnClick {
  private View view;
  private int isEnd = 0;
  private newsListPresenterImpl impl;
  private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
  private RecyclerViewAdapter mRecyclerViewAdapter;

  @Override protected void initData() {
    if (isVisible && isPrepred) {
      if (mPullLoadMoreRecyclerView != null) {
        mPullLoadMoreRecyclerView.setRefreshing(true);
      }
      impl = new newsListPresenterImpl(this);
      impl.requestNetWork(index + 1, 1, false);
    }
  }

  public static Fragment newInstance(int a) {
    NewsMainFragment newsMainFragment = new NewsMainFragment();
    Bundle bundle = new Bundle();
    bundle.putInt(FRAGMENT_INDEX, a);
    newsMainFragment.setArguments(bundle);
    return newsMainFragment;
  }

  @Override protected View initView() {
    if (view == null) {
      view = View.inflate(getActivity(), R.layout.fragment_news, null);
      mPullLoadMoreRecyclerView =
          (PullLoadMoreRecyclerView) view.findViewById(R.id.pullLoadMoreRecyclerView);
      mPullLoadMoreRecyclerView.setLinearLayout();
      mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(this);
      mRecyclerViewAdapter = new RecyclerViewAdapter(getActivity(),this);
      mPullLoadMoreRecyclerView.setAdapter(mRecyclerViewAdapter);
      mPullLoadMoreRecyclerView.setFooterViewText("loading...");
    }

    return view;
  }

  @Override public void setData(List<tnogo> datas) {
    if (datas.size() > 0) {
      mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
      mRecyclerViewAdapter.addAllData(datas);
    } else {
      isEnd = 1;
    }
  }

  @Override public void netWorkError() {
    mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
    ToastShow("请求失败");
  }

  @Override public void onRefresh() {
    mRecyclerViewAdapter.clearData();
    impl.requestNetWork(index + 1, 1, false);
  }

  @Override public void onLoadMore() {
    ++page;
    impl.requestNetWork(index + 1, page, false);
  }

  @Override public void OnClick(tnogo tnogo) {
    impl.onClick(tnogo);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    view=null;
  }
}
