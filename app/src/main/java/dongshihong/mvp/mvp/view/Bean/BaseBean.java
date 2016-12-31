package dongshihong.mvp.mvp.view.Bean;

import java.util.List;

/**
 * Created by Dsh on 2016/11/30
 */

public class BaseBean<T> {
  private List<T> mTList ;

  public List<T> getInfo() {
    return mTList;
  }

  public void setInfo(List<T> TList) {
    mTList = TList;
  }

  public class NewsListBean extends BaseBean<NewsListInfo> {
  }

  public class TabNewsBean extends BaseBean<Tngou> {
  }
}
