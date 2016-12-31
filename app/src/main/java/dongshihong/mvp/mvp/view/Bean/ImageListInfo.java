package dongshihong.mvp.mvp.view.Bean;

import java.util.List;

/**
 * Created by Dsh on 2016/12/9
 */

public class ImageListInfo {
  private boolean status;
  private int total;
  private List<ImageBean> tngou;

  public void setStatus(boolean status) {
    this.status = status;
  }

  public boolean getStatus() {
    return status;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getTotal() {
    return total;
  }

  public List<ImageBean> getTngou() {
    return tngou;
  }

  public void setTngou(List<ImageBean> tngou) {
    this.tngou = tngou;
  }
}

