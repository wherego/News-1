package dongshihong.mvp.mvp.view.presenter;

/**
 * Created by Dsh on 2016/11/30
 */

public class BasePresenterImpl<T> {
  T view;

  public BasePresenterImpl(T view) {
    this.view = view;
  }
}
