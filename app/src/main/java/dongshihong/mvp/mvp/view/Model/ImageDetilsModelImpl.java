package dongshihong.mvp.mvp.view.Model;

import dongshihong.mvp.mvp.view.Bean.ImageDetilsInfo;
import dongshihong.mvp.network.NetWorkRequest;
import rx.Subscriber;

/**
 * Created by Dsh on 2016/12/16
 */

public class ImageDetilsModelImpl implements BaseModel.ImageDetilsModel {

  @Override public void netWorkImage(int id, BaseDataBridge.ImageListData imageListData) {
    NetWorkRequest.imageDetail(id, new Subscriber<ImageDetilsInfo>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {
        imageListData.error();
      }

      @Override public void onNext(ImageDetilsInfo imageDetilsInfo) {
        if(imageDetilsInfo!=null){
          imageListData.addData(imageDetilsInfo.getList());
        }
      }
    });
  }
}
