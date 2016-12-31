package dongshihong.mvp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.ButterKnife;
import dongshihong.mvp.utils.RxUtils;

/**
 * Created by Dsh on 2016/11/30
 */

@SuppressWarnings("ALL") public abstract class BaseFragment extends Fragment {
  protected boolean isVisible;
  protected static final String FRAGMENT_INDEX = "fragment_index";
  protected int index = 0;
  protected int page = 1;
  protected boolean isNull = false;
  protected View view;
  protected boolean isPrepred = false;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle bundle = getArguments();
    if (bundle != null) {
      index = bundle.getInt(FRAGMENT_INDEX);
    }
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = initView();
    ButterKnife.bind(this, view);
    isPrepred = true;
    return view;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    initData();
  }

  @Override public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    if (getUserVisibleHint()) {
      isVisible = true;
      onVisible();   //实现懒加载的方法
    } else {
      isVisible = false;
      onInvisible();
    }
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
  }

  private void onInvisible() {
  }

  private void onVisible() {
    initData();
  }

  public void ToastShow(String str) {
    Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
  }

  protected abstract void initData();

  protected abstract View initView();

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
    RxUtils.unsubscribe();
  }
}
