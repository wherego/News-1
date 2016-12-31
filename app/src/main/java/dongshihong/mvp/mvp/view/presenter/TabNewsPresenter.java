package dongshihong.mvp.mvp.view.presenter;

import dongshihong.mvp.mvp.view.BasePresenter.BasePresenter;
import dongshihong.mvp.mvp.view.Bean.Tngou;
import dongshihong.mvp.mvp.view.Model.BaseDataBridge;
import dongshihong.mvp.mvp.view.Model.BaseModel;
import dongshihong.mvp.mvp.view.Model.TabNewsModelImpl;
import dongshihong.mvp.mvp.view.View.BaseView;
import java.util.List;

/**
 * Created by Dsh on 2016/12/1
 */

public class TabNewsPresenter extends BasePresenterImpl<BaseView.TabNewsView>
    implements BasePresenter.TabNewsPresenter, BaseDataBridge.tabNewsData {

  private  BaseModel.TabNewsModel mTabNewsData;

  public TabNewsPresenter(BaseView.TabNewsView view) {
    super(view);
    mTabNewsData = new TabNewsModelImpl();
  }

  @Override public void requestNetWork() {
   mTabNewsData.netWork(this);
  }

  @Override public void addData(List<Tngou> data) {
    view.setData(data);
  }

  @Override public void error() {
   view.netWorkError();
  }
}
