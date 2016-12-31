package dongshihong.mvp.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import dongshihong.mvp.R;
import dongshihong.mvp.adapter.JokePicRecyclerViewAdapter;
import dongshihong.mvp.mvp.view.Bean.JokePicInfo;
import dongshihong.mvp.mvp.view.View.BaseView;
import dongshihong.mvp.mvp.view.presenter.JokePicPresenterImpl;
import dongshihong.mvp.utils.UIUtils;
import dongshihong.mvp.utils.WrapContentLinearLayoutManager;
import java.util.List;

/**
 * Created by Dsh on 2016/12/27
 */

public class ImageJokeFragment extends BaseFragment
    implements SwipeRefreshLayout.OnRefreshListener, BaseView.JokePic,
    JokePicRecyclerViewAdapter.ItemOnLongClick {
  private View view;
  private SwipeRefreshLayout mSwipeRefreshLayout;
  private RecyclerView mRecyclerView;
  private WrapContentLinearLayoutManager mLinearLayoutManager;
  private int lastVisibleItem;
  private JokePicRecyclerViewAdapter mJokePicRecyclerViewAdapter;
  private JokePicPresenterImpl mJokePicPresenter;
  private boolean mIsRefreshing = false;

  @Override protected void initData() {
    if (isPrepred && isVisible) {
      if (mJokePicRecyclerViewAdapter != null) {
        mJokePicRecyclerViewAdapter.cleanData();
        mSwipeRefreshLayout.setRefreshing(true);
        mIsRefreshing=true;
      }
      index = 1;
      mJokePicPresenter = new JokePicPresenterImpl(this);
      mJokePicPresenter.requestNetWork(1);
    }
  }

  @Override protected View initView() {
    view = View.inflate(UIUtils.getActivity(), R.layout.fragment_imagejoke, null);
    mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler);
    mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe);
    mJokePicRecyclerViewAdapter = new JokePicRecyclerViewAdapter(UIUtils.getActivity(), this);
    /*mSwipeRefreshLayout.setColorScheme(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.cardview_light_background),
        getResources().getColor(R.color.colorPrimary));*/
    mSwipeRefreshLayout.setProgressViewOffset(false, 0,
        (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24,
            getResources().getDisplayMetrics()));
    mSwipeRefreshLayout.setOnRefreshListener(this);
    mLinearLayoutManager = new WrapContentLinearLayoutManager(UIUtils.getActivity());
    mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == RecyclerView.SCROLL_STATE_IDLE
            && lastVisibleItem + 1 == mJokePicRecyclerViewAdapter.getItemCount()) {
          ++index;
          mJokePicPresenter.requestNetWork(index);
        }
      }

      @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
      }
    });
  //设置刷新时不能滑动
    mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
      @Override public boolean onTouch(View v, MotionEvent event) {
        if (mIsRefreshing) {
          return true;
        } else {
          return false;
        }
      }
    });
    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(mLinearLayoutManager);
    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    mRecyclerView.setAdapter(mJokePicRecyclerViewAdapter);
    return view;
  }

  @Override public void onRefresh() {
    mSwipeRefreshLayout.setRefreshing(true);
    mIsRefreshing=true;
    mJokePicRecyclerViewAdapter.cleanData();
    mJokePicPresenter.requestNetWork(1);
  }

  @Override public void setData(List<JokePicInfo> datas) {
    if (datas.size() > 0) {
      mJokePicRecyclerViewAdapter.addAllData(datas);
      mSwipeRefreshLayout.setRefreshing(false);
      mIsRefreshing=false;
    } else {
      ToastShow("没有更多数据");
    }
  }

  @Override public void netWorkError() {
    ToastShow("请求失败");
  }

  @Override public void ItemOnLongClick(int positinon) {

  }
}
