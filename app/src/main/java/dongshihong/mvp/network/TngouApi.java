package dongshihong.mvp.network;

import dongshihong.mvp.mvp.view.Bean.ImageDetilsInfo;
import dongshihong.mvp.mvp.view.Bean.ImageListInfo;
import dongshihong.mvp.mvp.view.Bean.NewsBeanInfo;
import dongshihong.mvp.mvp.view.Bean.NewsDetilsBean;
import dongshihong.mvp.mvp.view.Bean.TnogoInfo;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * by Dsh on 2016/12/1
 */
public interface TngouApi {

  @GET(Api.TAB_NAME) Observable<TnogoInfo> getTabName();

  @GET(Api.NEWS_LIST) Observable<NewsBeanInfo> getNewsList(@Query("id") int id,
      @Query("page") int page);

  @GET(Api.TAB_NEWS) Observable<TnogoInfo> getTabNews();

  @GET(Api.IMAGE_LIST) Observable<ImageListInfo> getImageList(@Query("id") int id,
      @Query("page") int page);

  @GET(Api.NEWS_SHOW) Observable<NewsDetilsBean> getNewsDetail(@Query("id") int id);

  @GET(Api.IMAGE_SHOW) Observable<ImageDetilsInfo> getImageDetail(@Query("id") int id);

}
