package dongshihong.mvp.mvp.view.Bean;

import java.util.List;

/**
 * Created by Dsh on 2016/12/1
 */

public class TnogoInfo {
    private boolean status;
    private List<Tngou> tngou;
    public void setStatus(boolean status) {
      this.status = status;
    }
    public boolean getStatus() {
      return status;
    }

    public void setTngou(List<Tngou> tngou) {
      this.tngou = tngou;
    }
    public List<Tngou> getTngou() {
      return tngou;
    }

  }

