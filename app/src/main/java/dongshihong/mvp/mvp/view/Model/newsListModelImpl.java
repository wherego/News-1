package dongshihong.mvp.mvp.view.Model;

import dongshihong.mvp.mvp.view.Bean.NewsBeanInfo;
import dongshihong.mvp.network.NetWorkRequest;
import rx.Subscriber;

/**
 * Created by Dsh on 2016/11/30
 */

public class newsListModelImpl implements BaseModel.NewsListModel {
  @Override
  public void netWorkNewList(int id, int page, final BaseDataBridge.newsListData newsListData) {
    NetWorkRequest.newsList(id, page, new Subscriber<NewsBeanInfo>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {
        newsListData.error();
      }

      @Override public void onNext(NewsBeanInfo newsBeanInfo) {
        newsListData.addData(newsBeanInfo.getTngou());
      }
    });
  }
}
