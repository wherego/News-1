package dongshihong.mvp.mvp.view.presenter;

import dongshihong.mvp.mvp.view.BasePresenter.BasePresenter;
import dongshihong.mvp.mvp.view.Bean.JokePicInfo;
import dongshihong.mvp.mvp.view.Model.BaseDataBridge;
import dongshihong.mvp.mvp.view.Model.BaseModel;
import dongshihong.mvp.mvp.view.Model.JokePicModelImpl;
import dongshihong.mvp.mvp.view.View.BaseView;
import java.util.List;

/**
 * Created by Dsh on 2016/12/28
 */

public class JokePicPresenterImpl extends BasePresenterImpl<BaseView.JokePic>
    implements BaseDataBridge.JokePicData, BasePresenter.JokePicPresenter {

  private BaseModel.JokePicModel mJokePicModel;

  public JokePicPresenterImpl(BaseView.JokePic view) {
    super(view);
    mJokePicModel = new JokePicModelImpl();
  }

  @Override public void requestNetWork(int page) {
    mJokePicModel.netWorkJoke(page, this);
  }

  @Override public void addData(List<JokePicInfo> data) {
    view.setData(data);
  }

  @Override public void error() {
    view.netWorkError();
  }
}
