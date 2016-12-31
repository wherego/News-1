package dongshihong.mvp.mvp.view.presenter;

import dongshihong.mvp.R;
import dongshihong.mvp.mvp.view.BasePresenter.BasePresenter;
import dongshihong.mvp.mvp.view.View.BaseView;

/**
 * Created by Dsh on 2016/12/15
 */

public class ToolbarSharePresenterImpl extends BasePresenterImpl<BaseView.showShare>
    implements BasePresenter.ToolbarSharePresenter {
  public ToolbarSharePresenterImpl(BaseView.showShare view) {
    super(view);
  }

  @Override public void switchId(int id) {
    switch (id) {
      case R.id.share_toolbar:
        view.switchShare();
        break;
    }
  }
}
