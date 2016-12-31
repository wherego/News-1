package dongshihong.mvp.mvp.view.presenter;

import dongshihong.mvp.mvp.view.BasePresenter.BasePresenter;
import dongshihong.mvp.mvp.view.Bean.NewsDetilsBean;
import dongshihong.mvp.mvp.view.Model.BaseDataBridge;
import dongshihong.mvp.mvp.view.Model.BaseModel;
import dongshihong.mvp.mvp.view.Model.NewsDetilsModelImpl;
import dongshihong.mvp.mvp.view.View.BaseView;

/**
 * Created by Dsh on 2016/12/14
 */

public class NewsDetilsPresenterImpl extends BasePresenterImpl<BaseView.DetailContent>
    implements BasePresenter.NewsDetilsPresenter, BaseDataBridge.NewsDtilsData {
  private BaseModel.NewsDetilsModel mNewsDetilsModel;
  public NewsDetilsPresenterImpl(BaseView.DetailContent view) {
    super(view);
    mNewsDetilsModel=new NewsDetilsModelImpl();
  }

  @Override public void requestNetWork(int id) {
     mNewsDetilsModel.netWorkNews(id,this);
  }

  @Override public void addData(NewsDetilsBean newsDetilsBean) {
    if (newsDetilsBean != null && !newsDetilsBean.equals("")) {
      view.setData(newsDetilsBean);
      view.hideProgress();
    }
  }

  @Override public void error() {
    view.error();
  }



}
