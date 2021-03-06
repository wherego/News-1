package dongshihong.mvp.mvp.view.Model;

import dongshihong.mvp.mvp.view.Bean.TnogoInfo;
import dongshihong.mvp.network.NetWorkRequest;
import rx.Subscriber;

/**
 * Created by Dsh on 2016/12/9
 */

public class TabNameModelImpl implements BaseModel.TabNewsModel {
  @Override public void netWork(final BaseDataBridge.tabNewsData model) {
    NetWorkRequest.tabName(new Subscriber<TnogoInfo>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {
        model.error();
      }

      @Override public void onNext(TnogoInfo tnogoInfo) {
        if (tnogoInfo.getTngou().size() > 0) {
          model.addData(tnogoInfo.getTngou());
        }
      }
    });
  }
}
