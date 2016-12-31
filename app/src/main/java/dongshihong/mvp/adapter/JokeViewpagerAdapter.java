package dongshihong.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import dongshihong.mvp.fragment.CharJokeFragment;
import dongshihong.mvp.fragment.ImageJokeFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dsh on 2016/12/27
 */

public class JokeViewpagerAdapter extends BaseFragmentPagerAdapter<String> {
  private List<Fragment> mFragmentList;

  public JokeViewpagerAdapter(FragmentManager fm, List<String> data) {
    super(fm, data);
    mFragmentList = new ArrayList<>();
    mFragmentList.add(new CharJokeFragment());
    mFragmentList.add(new ImageJokeFragment());
  }

  @Override protected Fragment getFragmentItem(int a) {
    return mFragmentList.get(a);
  }

  @Override protected CharSequence getTitleName(String data) {
    return data;
  }
}
