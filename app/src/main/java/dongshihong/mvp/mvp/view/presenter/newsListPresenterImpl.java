package dongshihong.mvp.mvp.view.presenter;

import dongshihong.mvp.activity.NewsDetailActivity;
import dongshihong.mvp.mvp.view.BasePresenter.BasePresenter;
import dongshihong.mvp.mvp.view.Bean.tnogo;
import dongshihong.mvp.mvp.view.Model.BaseDataBridge;
import dongshihong.mvp.mvp.view.Model.BaseModel;
import dongshihong.mvp.mvp.view.Model.newsListModelImpl;
import dongshihong.mvp.mvp.view.View.BaseView;
import java.util.List;

/**
 * Created by Dsh on 2016/11/30
 */

public class newsListPresenterImpl extends BasePresenterImpl<BaseView.NewsListView>
    implements BasePresenter.NewsListPresenter, BaseDataBridge.newsListData {
  private BaseModel.NewsListModel mNewsListModel;

  public newsListPresenterImpl(BaseView.NewsListView view) {
    super(view);
    this.mNewsListModel = new newsListModelImpl();
  }

  @Override public void requestNetWork(int id, int page, boolean isNull) {

    mNewsListModel.netWorkNewList(id, page, this);
  }

  @Override public void onClick(tnogo info) {
    NewsDetailActivity.startIntent(info.getId());
  }

  @Override public void addData(List<tnogo> data) {
    view.setData(data);
  }

  @Override public void error() {
    view.netWorkError();
  }
}
