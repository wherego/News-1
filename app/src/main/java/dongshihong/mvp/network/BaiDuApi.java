package dongshihong.mvp.network;

import dongshihong.mvp.mvp.view.Bean.JokeCharInfo;
import dongshihong.mvp.mvp.view.Bean.JokePicInfoBean;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

public interface BaiDuApi {

    @GET(Api.JOKE_TEXT)
    @Headers(Api.BAIDU_KEY) rx.Observable<JokeCharInfo> getJokeText(@Query("page") int page);



    @GET(Api.JOKE_PIC)
    @Headers(Api.BAIDU_KEY) Observable<JokePicInfoBean> getJokePic(@Query("page") int page);
}
