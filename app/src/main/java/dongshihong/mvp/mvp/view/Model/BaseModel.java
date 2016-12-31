package dongshihong.mvp.mvp.view.Model;

/**
 * Created by Dsh on 2016/11/30
 */

public interface BaseModel<T> {
  void netWork(T model);

  interface NewsListModel {
    void netWorkNewList(int id, int page, BaseDataBridge.newsListData newsListData);
  }

  interface TabNewsModel extends BaseModel<BaseDataBridge.tabNewsData> {
  }

  interface ImageListModel {
    void netWorkImgeList(int id, int page, BaseDataBridge.ImageListDta imageListDta);
  }

  interface NewsDetilsModel {
    void netWorkNews(int id,BaseDataBridge.NewsDtilsData newsDtilsData);
  }

  interface ImageDetilsModel{
    void netWorkImage(int id,BaseDataBridge.ImageListData imageListData);
  }
  interface JokeTextModel{
    void netWorkJoke(int page,BaseDataBridge.JokeTextData jokeTextData);
  }
  interface JokePicModel{
    void netWorkJoke(int page,BaseDataBridge.JokePicData jokePicData);
  }
}
