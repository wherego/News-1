package dongshihong.mvp.mvp.view.Bean;

import java.util.List;

/**
 * Created by Dsh on 2016/12/1
 */

public class NewsBeanInfo {

  private boolean status;
  private int total;
  private List<tnogo> tngou;

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

  public List<tnogo> getTngou() {
    return tngou;
  }

  public void setTngou(List<tnogo> tngou) {
    this.tngou = tngou;
  }
}

