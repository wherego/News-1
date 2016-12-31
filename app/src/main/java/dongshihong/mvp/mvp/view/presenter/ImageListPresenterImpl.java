package dongshihong.mvp.mvp.view.presenter;

import dongshihong.mvp.activity.ImageDetailActivity;
import dongshihong.mvp.mvp.view.BasePresenter.BasePresenter;
import dongshihong.mvp.mvp.view.Bean.ImageBean;
import dongshihong.mvp.mvp.view.Model.BaseDataBridge;
import dongshihong.mvp.mvp.view.Model.BaseModel;
import dongshihong.mvp.mvp.view.Model.ImageListModelImpl;
import dongshihong.mvp.mvp.view.View.BaseView;
import java.util.List;

/**
 * Created by Dsh on 2016/12/9
 */

public class ImageListPresenterImpl extends BasePresenterImpl<BaseView.ImageListView>
    implements BaseDataBridge.ImageListDta, BasePresenter.ImageListPresenter {
  private BaseModel.ImageListModel mImageListModel;

  public ImageListPresenterImpl(BaseView.ImageListView view) {
    super(view);
    mImageListModel = new ImageListModelImpl();
  }

  @Override public void addData(List<ImageBean> data) {
    view.setData(data);
  }

  @Override public void error() {
    view.netWorkError();
  }

  @Override public void requestNetWork(int id, int page) {
    mImageListModel.netWorkImgeList(id, page, this);
  }

  @Override public void onClick(ImageBean imageBean) {
    ImageDetailActivity.startIntent(imageBean.getId(), imageBean.getTitle());
  }
}
