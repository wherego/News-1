package dongshihong.mvp.mvp.view.Bean;

import java.util.List;

/**
 * Created by Dsh on 2016/12/27
 */

public class JokeText {
  public String allNum;
  public String allPages;
  public List<JokeTextInfo> contentlist;

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

  public List<JokeTextInfo> getContentlist() {
    return contentlist;
  }

  public void setContentlist(List<JokeTextInfo> contentlist) {
    this.contentlist = contentlist;
  }
}
