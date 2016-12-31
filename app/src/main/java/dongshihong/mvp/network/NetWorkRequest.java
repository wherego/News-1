package dongshihong.mvp.network;

import dongshihong.mvp.mvp.view.Bean.ImageDetilsInfo;
import dongshihong.mvp.mvp.view.Bean.ImageListInfo;
import dongshihong.mvp.mvp.view.Bean.JokeCharInfo;
import dongshihong.mvp.mvp.view.Bean.JokePicInfoBean;
import dongshihong.mvp.mvp.view.Bean.NewsBeanInfo;
import dongshihong.mvp.mvp.view.Bean.NewsDetilsBean;
import dongshihong.mvp.mvp.view.Bean.TnogoInfo;
import dongshihong.mvp.utils.RxUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * by Dsh on 2016/12/1
 */
public class NetWorkRequest {
  public static void newsList(int id, int page, Subscriber<NewsBeanInfo> subscriber) {
    RxUtils.unsubscribe();
    RxUtils.subscription = Network.getTngouApi()
        .getNewsList(id, page)
        .subscribeOn(Schedulers.io())
        .unsubscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber);
  }

  public static void tabNews(Subscriber<TnogoInfo> subscriber) {
    RxUtils.unsubscribe();
    RxUtils.subscription = Network.getTngouApi()
        .getTabNews()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber);
  }

  public static void tabName(Subscriber<TnogoInfo> subscriber) {
    RxUtils.unsubscribe();
    RxUtils.subscription = Network.getTngouApi()
        .getTabName()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber);
  }

  public static void ImageList(int id, int page, Subscriber<ImageListInfo> subscriber) {
    RxUtils.unsubscribe();
    RxUtils.subscription = Network.getTngouApi()
        .getImageList(id, page)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber);
  }

  public static void NewsDetils(int id, Subscriber<NewsDetilsBean> subscriber) {
    RxUtils.unsubscribe();
    RxUtils.subscription = Network.getTngouApi()
        .getNewsDetail(id)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber);
  }

  public static void imageDetail(int id, Subscriber<ImageDetilsInfo> subscriber) {
    RxUtils.unsubscribe();
    RxUtils.subscription = Network.getTngouApi()
        .getImageDetail(id)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber);
  }

  public static void JokeText(int page, Subscriber<JokeCharInfo> subscriber) {
    RxUtils.unsubscribe();
    RxUtils.subscription = Network.getBaiDuApi()
        .getJokeText(page)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber);
  }

  public static void JokePic(int page, Subscriber<JokePicInfoBean> subscriber) {
    RxUtils.unsubscribe();
    RxUtils.subscription = Network.getBaiDuApi()
        .getJokePic(page)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber);
  }
}
