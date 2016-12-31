package dongshihong.mvp.mvp.view.Bean;

import java.util.List;

/**
 * Created by Dsh on 2016/12/16
 */

public class ImageDetilsInfo {
    private int count;
    private int fcount;
    private int galleryclass;
    private int id;
    private String img;
    private List<ImageDetailBean> list;
    private int rcount;
    private int size;
    private boolean status;
    private long time;
    private String title;
    private String url;
    public void setCount(int count) {
      this.count = count;
    }
    public int getCount() {
      return count;
    }

    public void setFcount(int fcount) {
      this.fcount = fcount;
    }
    public int getFcount() {
      return fcount;
    }

    public void setGalleryclass(int galleryclass) {
      this.galleryclass = galleryclass;
    }
    public int getGalleryclass() {
      return galleryclass;
    }

    public void setId(int id) {
      this.id = id;
    }
    public int getId() {
      return id;
    }

    public void setImg(String img) {
      this.img = img;
    }
    public String getImg() {
      return img;
    }

  public List<ImageDetailBean> getList() {
    return list;
  }

  public void setList(List<ImageDetailBean> list) {
    this.list = list;
  }

  public boolean isStatus() {
    return status;
  }

  public void setRcount(int rcount) {
      this.rcount = rcount;
    }
    public int getRcount() {
      return rcount;
    }

    public void setSize(int size) {
      this.size = size;
    }
    public int getSize() {
      return size;
    }

    public void setStatus(boolean status) {
      this.status = status;
    }
    public boolean getStatus() {
      return status;
    }

    public void setTime(long time) {
      this.time = time;
    }
    public long getTime() {
      return time;
    }

    public void setTitle(String title) {
      this.title = title;
    }
    public String getTitle() {
      return title;
    }

    public void setUrl(String url) {
      this.url = url;
    }
    public String getUrl() {
      return url;
    }

  }


