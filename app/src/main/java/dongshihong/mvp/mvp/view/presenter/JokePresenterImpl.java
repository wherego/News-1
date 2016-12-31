package dongshihong.mvp.mvp.view.presenter;

import dongshihong.mvp.mvp.view.BasePresenter.BasePresenter;
import dongshihong.mvp.mvp.view.Bean.JokeTextInfo;
import dongshihong.mvp.mvp.view.Model.BaseDataBridge;
import dongshihong.mvp.mvp.view.Model.BaseModel;
import dongshihong.mvp.mvp.view.Model.JokeTextModelImpl;
import dongshihong.mvp.mvp.view.View.BaseView;
import java.util.List;

/**
 * Created by Dsh on 2016/12/27
 */

public class JokePresenterImpl extends BasePresenterImpl<BaseView.JokeText>
    implements BasePresenter.JokeTextPresenter, BaseDataBridge.JokeTextData {
  private BaseModel.JokeTextModel mJokeTextModel;
  public JokePresenterImpl(BaseView.JokeText view) {
    super(view);

  }
  @Override public void requestNetWork(int page) {
     mJokeTextModel=new JokeTextModelImpl();
    mJokeTextModel.netWorkJoke(page,this);

  }

  @Override public void addData(List<JokeTextInfo> data) {
    view.setData(data);
  }

  @Override public void error() {
    view.netWorkError();
  }
}
