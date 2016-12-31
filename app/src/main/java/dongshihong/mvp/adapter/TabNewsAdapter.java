package dongshihong.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import dongshihong.mvp.fragment.ImageMainFragment;
import dongshihong.mvp.fragment.NewsMainFragment;
import dongshihong.mvp.mvp.view.Bean.Tngou;
import java.util.List;

/**
 * Created by Dsh on 2016/11/30
 */

public class TabNewsAdapter extends BaseFragmentPagerAdapter<Tngou> {
  private int index;
  public TabNewsAdapter(FragmentManager fm, List<Tngou> data, int a) {
    super(fm, data);
    this.index = a;
  }

  @Override protected Fragment getFragmentItem(int a) {
    if (index == 1) {
      return NewsMainFragment.newInstance(a);
    } else if (index == 2) {
      return ImageMainFragment.newInstance(a);
    }
    return null;
  }

  @Override protected CharSequence getTitleName(Tngou data) {
    return data.getName();
  }
}
