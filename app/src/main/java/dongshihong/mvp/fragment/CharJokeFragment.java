package dongshihong.mvp.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import dongshihong.mvp.R;
import dongshihong.mvp.adapter.JokeRecyclerViewAdapter;
import dongshihong.mvp.mvp.view.BasePresenter.BasePresenter;
import dongshihong.mvp.mvp.view.Bean.JokeTextInfo;
import dongshihong.mvp.mvp.view.View.BaseView;
import dongshihong.mvp.mvp.view.presenter.JokePresenterImpl;
import dongshihong.mvp.utils.UIUtils;
import dongshihong.mvp.utils.WrapContentLinearLayoutManager;
import java.util.List;

/**
 * Created by Dsh on 2016/12/27
 */

public class CharJokeFragment extends BaseFragment
    implements SwipeRefreshLayout.OnRefreshListener, BaseView.JokeText,
    JokeRecyclerViewAdapter.ItemOnLongClick {
  private View view;
  private int index = 1;
  private boolean mIsRefreshing = false;
  private BasePresenter.JokeTextPresenter mJokeTextPresenter;
  private JokeRecyclerViewAdapter JokeRecyclerViewAdapter;
  private SwipeRefreshLayout mSwipeRefreshLayout;
  private RecyclerView mRecyclerView;
  private WrapContentLinearLayoutManager mLinearLayoutManager;
  private int lastVisibleItem;

  @Override protected void initData() {
    if (isPrepred && isVisible) {
      if (JokeRecyclerViewAdapter != null) {
        JokeRecyclerViewAdapter.cleanData();
        mSwipeRefreshLayout.setRefreshing(true);
        mIsRefreshing = true;
      }
      index = 1;
      mJokeTextPresenter = new JokePresenterImpl(this);
      mJokeTextPresenter.requestNetWork(1);
    }
  }

  @Override protected View initView() {
    view = View.inflate(UIUtils.getActivity(), R.layout.fragment_charjoke, null);
    mRecyclerView = (RecyclerView) view.findViewById(R.id.recylerview);
    JokeRecyclerViewAdapter = new JokeRecyclerViewAdapter(UIUtils.getActivity(), this);
    mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_content);
    /*mSwipeRefreshLayout.setColorScheme(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.cardview_light_background),
        getResources().getColor(R.color.colorPrimary));*/
    //第一次进入时显示 调整进度条与屏幕上边的距离
    mSwipeRefreshLayout.setProgressViewOffset(false, 0,
        (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24,
            getResources().getDisplayMetrics()));
    mSwipeRefreshLayout.setOnRefreshListener(this);
    mLinearLayoutManager = new WrapContentLinearLayoutManager(UIUtils.getActivity());
    mRecyclerView.setOnScrollListener(new OnScrollListener() {
      @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == RecyclerView.SCROLL_STATE_IDLE
            && lastVisibleItem + 1 == JokeRecyclerViewAdapter.getItemCount()) {
          ++index;
          mJokeTextPresenter.requestNetWork(index);
        }
      }

      @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
      }
    });
    //刷新时不能滑动
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
    mRecyclerView.setAdapter(JokeRecyclerViewAdapter);
    return view;
  }

  @Override public void setData(List<JokeTextInfo> datas) {
    if (datas.size() > 0) {
      JokeRecyclerViewAdapter.addAllData(datas);
      mSwipeRefreshLayout.setRefreshing(false);
      mIsRefreshing = false;
    } else {
      ToastShow("没有更多数据···");
    }
  }

  @Override public void netWorkError() {
    ToastShow("请求失败");
  }

  @Override public void onRefresh() {
    mSwipeRefreshLayout.setRefreshing(true);
    mIsRefreshing = true;
    JokeRecyclerViewAdapter.cleanData();
    mJokeTextPresenter.requestNetWork(1);
  }

  @Override public void ItemOnLongClick(int positinon) {
    ToastShow("长按");
  }
}
