package dongshihong.mvp.mvp.view.BasePresenter;

import dongshihong.mvp.mvp.view.Bean.ImageBean;
import dongshihong.mvp.mvp.view.Bean.tnogo;

/**
 * Created by Dsh on 2016/11/30
 */

public interface BasePresenter {

  /**
   * 新闻列表图片列表的调用方法
   */
  interface NewsListPresenter {
    void requestNetWork(int id, int page, boolean isNull);

    void onClick(tnogo info);
  }

  /**
   * tab的回调方法
   */
  interface TabNewsPresenter {
    void requestNetWork();
  }

  /**
   * 图片的回调方法
   */

  interface ImageListPresenter {
    void requestNetWork(int id, int page);

    void onClick(ImageBean imageBean);
  }

  /**
   * 新闻内容的回调方法
   */
  interface NewsDetilsPresenter {
    void requestNetWork(int id);
  }

  /**
   * toolbar的分享回调
   */
  interface ToolbarSharePresenter {
    void switchId(int id);
  }

  /**
   * 获取图片详情的数组
   */
  interface ImageDetilsPresenter {
    void requestNetWork(int id, String title);

    void competence(int requestCode, int[] grantResults);
  }

  interface JokeTextPresenter {
    void requestNetWork(int page);
  }

  interface JokePicPresenter {
    void requestNetWork(int page);
  }
}
