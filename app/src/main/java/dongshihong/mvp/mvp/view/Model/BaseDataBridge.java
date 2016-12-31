package dongshihong.mvp.mvp.view.Model;

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

public interface BaseDataBridge<T> {

  void addData(List<T> data);

  void error();

  interface newsListData extends BaseDataBridge<tnogo> {
  }

  interface tabNewsData extends BaseDataBridge<Tngou> {
  }

  interface ImageListData extends BaseDataBridge<ImageDetailBean> {

  }

  interface ImageListDta extends BaseDataBridge<ImageBean> {
  }

  interface NewsDtilsData {
    void addData(NewsDetilsBean newsDetilsBean);

    void error();
  }
  interface JokeTextData extends BaseDataBridge<JokeTextInfo>{}


  interface JokePicData extends BaseDataBridge<JokePicInfo>{}
}
