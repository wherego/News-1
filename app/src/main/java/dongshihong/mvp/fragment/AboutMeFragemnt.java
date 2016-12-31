package dongshihong.mvp.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import dongshihong.mvp.R;
import dongshihong.mvp.utils.UIUtils;

/**
 * Created by Dsh on 2016/12/28
 */

public class AboutMeFragemnt extends BaseFragment {
  private View view;
  private ImageView mImageView;
  private TextView mTextView;

  @Override protected void initData() {

  }

  @Override protected View initView() {
    view = View.inflate(UIUtils.getActivity(), R.layout.abuoutfragment, null);
    mImageView = (ImageView) view.findViewById(R.id.ima);
    mTextView = (TextView) view.findViewById(R.id.text);

    mTextView.setText("用到的依赖：\n"
        + "compile 'io.reactivex:rxjava:1.1.5'\n"
        + "  compile 'io.reactivex:rxandroid:1.2.0'\n"
        + "  compile 'com.squareup.retrofit2:retrofit:2.0.2'\n"
        + "  compile 'com.squareup.retrofit2:converter-gson:2.0.2'\n"
        + "  compile 'com.squareup.retrofit2:adapter-rxjava:2.0.2'\n"
        + "  compile 'com.github.bumptech.glide:glide:3.7.0'\n"
        + "  compile 'com.rengwuxian.materialedittext:library:2.1.4'\n"
        + "  compile 'com.jakewharton:butterknife:7.0.1'\n"
        + "  compile 'com.jakewharton.rxbinding:rxbinding:0.4.0'"+"\n"+"github:https://github.com/imkobe\n"+"gmail:imkobedroid@gmail.com");
    return view;
  }
}
