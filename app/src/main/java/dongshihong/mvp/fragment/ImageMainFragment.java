package dongshihong.mvp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import dongshihong.mvp.R;
import dongshihong.mvp.adapter.ImageRecyclerViewAdapter;
import dongshihong.mvp.mvp.view.Bean.ImageBean;
import dongshihong.mvp.mvp.view.View.BaseView;
import dongshihong.mvp.mvp.view.presenter.ImageListPresenterImpl;
import java.util.List;

/**
 * Created by Dsh on 2016/12/9
 */

public class ImageMainFragment extends BaseFragment
    implements BaseView.ImageListView, ImageRecyclerViewAdapter.OnClick {
  private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
  private View view;
  private ImageRecyclerViewAdapter mImageRecyclerViewAdapter;
  private ImageListPresenterImpl mImageListView;
  private int isEnd = 0;
  private boolean isLoad = false;

  @Override protected void initData() {
    if (isVisible && isPrepred) {
      if (mPullLoadMoreRecyclerView != null) {
        mPullLoadMoreRecyclerView.setRefreshing(true);
      }
      mImageRecyclerViewAdapter.clearData();
      mImageListView = new ImageListPresenterImpl(this);
      mImageListView.requestNetWork(index + 1, 1);
    } else {
      return;
    }
  }

  @Override protected View initView() {
    view = View.inflate(getActivity(), R.layout.fragment_news, null);
    mPullLoadMoreRecyclerView =
        (PullLoadMoreRecyclerView) view.findViewById(R.id.pullLoadMoreRecyclerView);
    mPullLoadMoreRecyclerView.setGridLayout(2);
    mImageRecyclerViewAdapter = new ImageRecyclerViewAdapter(getActivity());
    mPullLoadMoreRecyclerView.setAdapter(mImageRecyclerViewAdapter);
    mPullLoadMoreRecyclerView.setRefreshing(true);
    mPullLoadMoreRecyclerView.setFooterViewText("loading...");
    mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(
        new PullLoadMoreRecyclerView.PullLoadMoreListener() {
          @Override public void onRefresh() {
            mImageRecyclerViewAdapter.clearData();
            mImageListView.requestNetWork(index + 1, 1);
          }

          @Override public void onLoadMore() {
            ++page;
            mImageListView.requestNetWork(index + 1, page);
          }
        });
    return view;
  }

  public static Fragment newInstance(int a) {
    ImageMainFragment imageMainFragment = new ImageMainFragment();
    Bundle bundle = new Bundle();
    bundle.putInt(FRAGMENT_INDEX, a);
    imageMainFragment.setArguments(bundle);
    return imageMainFragment;
  }

  @Override public void setData(List<ImageBean> datas) {
    if (datas.size() > 0) {
      mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
      mImageRecyclerViewAdapter.addAllData(datas, this);
    } else {
      isEnd = 1;
      ToastShow("没有更多数据了");
    }
  }

  @Override public void netWorkError() {
    ToastShow("请求失败");
  }

  @Override public void onDestroy() {
    super.onDestroy();
    view = null;
  }

  @Override public void OnClick(ImageBean imageBean) {
    mImageListView.onClick(imageBean);
  }
}
