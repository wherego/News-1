package dongshihong.mvp.mvp.view.Model;

import android.util.Log;
import dongshihong.mvp.mvp.view.Bean.NewsDetilsBean;
import dongshihong.mvp.network.NetWorkRequest;
import rx.Subscriber;

/**
 * Created by Dsh on 2016/12/14
 */

public class NewsDetilsModelImpl implements BaseModel.NewsDetilsModel {

  @Override public void netWorkNews(int id, final BaseDataBridge.NewsDtilsData newsDtilsData) {
    NetWorkRequest.NewsDetils(id, new Subscriber<NewsDetilsBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {
        Log.v("日志",e.toString());
        newsDtilsData.error();
      }

      @Override public void onNext(NewsDetilsBean newsDetilsBean) {
        newsDtilsData.addData(newsDetilsBean);
      }
    });
  }
}
