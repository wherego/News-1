package dongshihong.mvp.mvp.view.Model;

import dongshihong.mvp.mvp.view.Bean.ImageListInfo;
import dongshihong.mvp.network.NetWorkRequest;
import rx.Subscriber;

/**
 * Created by Dsh on 2016/12/9
 */

public class ImageListModelImpl implements BaseModel.ImageListModel {
  @Override
  public void netWorkImgeList(int id, int page, final BaseDataBridge.ImageListDta imageListDta) {
    NetWorkRequest.ImageList(id, page, new Subscriber<ImageListInfo>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {
        imageListDta.error();
      }

      @Override public void onNext(ImageListInfo imageListInfo) {
        if (imageListInfo.getTngou().size() > 0) {
          imageListDta.addData(imageListInfo.getTngou());
        }
      }
    });
  }
}
