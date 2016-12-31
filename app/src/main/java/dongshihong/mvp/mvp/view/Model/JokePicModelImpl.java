package dongshihong.mvp.mvp.view.Model;

import dongshihong.mvp.mvp.view.Bean.JokePicInfoBean;
import dongshihong.mvp.network.NetWorkRequest;
import rx.Subscriber;

/**
 * Created by Dsh on 2016/12/28
 */

public class JokePicModelImpl implements BaseModel.JokePicModel {
  @Override public void netWorkJoke(int page, BaseDataBridge.JokePicData jokePicData) {
    NetWorkRequest.JokePic(page, new Subscriber<JokePicInfoBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {
        jokePicData.error();
      }

      @Override public void onNext(JokePicInfoBean jokePicInfoBean) {
          jokePicData.addData(jokePicInfoBean.getShowapi_res_body().getContentlist());
      }
    });
  }
}
