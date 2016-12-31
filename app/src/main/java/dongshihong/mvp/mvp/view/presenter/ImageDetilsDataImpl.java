package dongshihong.mvp.mvp.view.presenter;

import android.content.pm.PackageManager;
import android.widget.Toast;
import dongshihong.mvp.constant.Constant;
import dongshihong.mvp.mvp.view.BasePresenter.BasePresenter;
import dongshihong.mvp.mvp.view.Bean.ImageDetailBean;
import dongshihong.mvp.mvp.view.Model.BaseDataBridge;
import dongshihong.mvp.mvp.view.Model.BaseModel;
import dongshihong.mvp.mvp.view.Model.ImageDetilsModelImpl;
import dongshihong.mvp.mvp.view.View.BaseView;
import dongshihong.mvp.utils.UIUtils;
import java.util.List;

/**
 * Created by Dsh on 2016/12/16
 */

public class ImageDetilsDataImpl extends BasePresenterImpl<BaseView.ImageDetils>
    implements BasePresenter.ImageDetilsPresenter, BaseDataBridge.ImageListData {
  private BaseModel.ImageDetilsModel mImageDetilsModel;

  public ImageDetilsDataImpl(BaseView.ImageDetils view) {
    super(view);
    mImageDetilsModel = new ImageDetilsModelImpl();
  }

  @Override public void requestNetWork(int id, String title) {
    mImageDetilsModel.netWorkImage(id, this);
  }

  @Override public void competence(int requestCode, int[] grantResults) {
    if (requestCode == Constant.WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
      if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
      } else {
        Toast.makeText(UIUtils.getContext(), "无权限不能保存图片", Toast.LENGTH_LONG).show();
      }
    }
  }

  @Override public void addData(List<ImageDetailBean> data) {
    if (data.size() > 0) {
      view.setData(data);
    }
  }

  @Override public void error() {
    view.netWorkError();
  }
}
