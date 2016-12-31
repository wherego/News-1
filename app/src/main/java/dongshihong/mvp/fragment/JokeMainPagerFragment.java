package dongshihong.mvp.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Bind;
import dongshihong.mvp.R;
import dongshihong.mvp.adapter.JokeViewpagerAdapter;
import dongshihong.mvp.utils.UIUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dsh on 2016/12/27
 */

public class JokeMainPagerFragment extends BaseFragment {
  private View view;
  private JokeViewpagerAdapter mJokeViewpagerAdapter;
  @Bind(R.id.tab_layout) TabLayout mTabLayout;
  @Bind(R.id.viewPager) ViewPager mViewPager;
  List<String> mList = new ArrayList<>();

  @Override protected void initData() {
    mList.add(getResources().getString(R.string.joke1));
    mList.add(getResources().getString(R.string.joke2));
    mJokeViewpagerAdapter = new JokeViewpagerAdapter(getChildFragmentManager(), mList);
    mViewPager.setAdapter(mJokeViewpagerAdapter);
    mViewPager.setOffscreenPageLimit(mList.size());
    mTabLayout.setupWithViewPager(mViewPager);
  }

  @Override protected View initView() {
    view = View.inflate(UIUtils.getActivity(), R.layout.fragment_joke, null);
    return view;
  }
}
