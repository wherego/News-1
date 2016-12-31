package dongshihong.mvp.mvp.view.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import dongshihong.mvp.fragment.BaseFragment;

/**
 * Created by Dsh on 2016/12/12
 */

public abstract class MyFragment extends BaseFragment {

  protected View mRootView;
  public Context mContext;
  protected boolean isVisible;
  private boolean isPrepared;
  private boolean isFirst = true;

  public MyFragment() {

  }

  @Override public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    if (getUserVisibleHint()) {
      isVisible = true;
      lazyLoad();
    } else {
      isVisible = false;
      onInvisible();
    }
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mContext = getActivity();
    setHasOptionsMenu(true);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    if (mRootView == null) {
      mRootView = initView();
    }
    return mRootView;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    isPrepared = true;
    lazyLoad();
  }

  protected void lazyLoad() {
    if (!isPrepared || !isVisible || !isFirst) {
      return;
    }
    initData();
    isFirst = false;
  }

  protected void onInvisible() {

  }

  public abstract View initView();

  public abstract void initData();
}
