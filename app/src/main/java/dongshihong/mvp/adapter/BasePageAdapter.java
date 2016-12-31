package dongshihong.mvp.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/**
 * Created by Dsh on 2016/12/16
 */

public abstract class BasePageAdapter<T> extends PagerAdapter {
  List<T> mTList;

  public BasePageAdapter(List<T> list) {
    if (list.size() > 0) {
      this.mTList = list;
    }
  }

  @Override public int getCount() {
    return mTList.size();
  }

  @Override public boolean isViewFromObject(View view, Object object) {
    return view == object;
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {
    return instantiate(container, position, mTList.get(position));
  }

  @Override public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((View) object);
  }

  protected abstract Object instantiate(ViewGroup viewGroup, int position, T data);
}
