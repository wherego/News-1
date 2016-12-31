package dongshihong.mvp.mvp.view.Bean;

import java.util.List;

/**
 * Created by Dsh on 2016/12/28
 */

public class JokePic {
  private String allNum;
  private String allPages;
  private List<JokePicInfo> contentlist;

  public String getAllNum() {
    return allNum;
  }

  public void setAllNum(String allNum) {
    this.allNum = allNum;
  }

  public String getAllPages() {
    return allPages;
  }

  public void setAllPages(String allPages) {
    this.allPages = allPages;
  }

  public List<JokePicInfo> getContentlist() {
    return contentlist;
  }

  public void setContentlist(List<JokePicInfo> contentlist) {
    this.contentlist = contentlist;
  }
}
