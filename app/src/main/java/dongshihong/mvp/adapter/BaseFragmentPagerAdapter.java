package dongshihong.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

/**
 * Created by Dsh on 2016/11/30
 */

public abstract class BaseFragmentPagerAdapter<T> extends FragmentPagerAdapter {
  public List<T> data;

  public BaseFragmentPagerAdapter(FragmentManager fm, List<T> data) {
    super(fm);
    this.data = data;
  }

  @Override public Fragment getItem(int position) {
    return getFragmentItem(position);
  }

  @Override public int getCount() {
    return data.size();
  }

  @Override public CharSequence getPageTitle(int position) {
    return getTitleName(data.get(position));
  }

  protected abstract Fragment getFragmentItem(int a);

  protected abstract CharSequence getTitleName(T data);
}
