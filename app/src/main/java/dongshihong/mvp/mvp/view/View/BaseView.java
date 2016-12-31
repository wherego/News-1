package dongshihong.mvp.mvp.view.View;

import dongshihong.mvp.mvp.view.Bean.ImageBean;
import dongshihong.mvp.mvp.view.Bean.ImageDetailBean;
import dongshihong.mvp.mvp.view.Bean.JokePicInfo;
import dongshihong.mvp.mvp.view.Bean.JokeTextInfo;
import dongshihong.mvp.mvp.view.Bean.NewsDetilsBean;
import dongshihong.mvp.mvp.view.Bean.Tngou;
import dongshihong.mvp.mvp.view.Bean.tnogo;
import java.util.List;

/**
 * Created by Dsh on 2016/11/30
 */

public interface BaseView<T> {
  void setData(List<T> datas);

  void netWorkError();

  interface MainView {

    void switchNews();

    void switchImageClassification();

    void switchNewImage();

    void switchJoke();

    void switchAbout();
  }

  interface TabNewsView extends BaseView<Tngou> {
  }

  interface NewsListView extends BaseView<tnogo> {
  }

  interface ImageListView extends BaseView<ImageBean> {
  }

  interface ImageDetils extends BaseView<ImageDetailBean> {
  }

  interface DetailContent {
    void setData(NewsDetilsBean newsDetilsBean);

    void error();

    void hideProgress();

    void showPregress();
  }

  interface showShare {
    void switchShare();
  }

  interface JokeText extends BaseView<JokeTextInfo> {
  }

  interface JokePic extends BaseView<JokePicInfo>{}
}
