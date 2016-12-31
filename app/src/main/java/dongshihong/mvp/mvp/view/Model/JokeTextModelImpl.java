package dongshihong.mvp.mvp.view.Model;

import dongshihong.mvp.mvp.view.Bean.JokeCharInfo;
import dongshihong.mvp.network.NetWorkRequest;
import rx.Subscriber;

/**
 * Created by Dsh on 2016/12/27
 */

public class JokeTextModelImpl implements BaseModel.JokeTextModel {
  @Override public void netWorkJoke(int page, BaseDataBridge.JokeTextData jokeTextData) {

    NetWorkRequest.JokeText(page, new Subscriber<JokeCharInfo>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable throwable) {
        String s=throwable.toString();
      }

      @Override public void onNext(JokeCharInfo jokeCharInfo) {
        jokeTextData.addData(jokeCharInfo.getShowapi_res_body().getContentlist());
      }
    });
   /* //另外一种网络请求 jackson解析Gson
    ApiService.getInstance()
        .createApiService(BaiDuApi.class)
        .getJokeText(page)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<JokeCharInfo>() {
          @Override public void call(JokeCharInfo jokeCharInfo) {
            jokeTextData.addData(jokeCharInfo.resbody.contentlist);
          }
        }, new ErrorResponse() {
          @Override public void ErrorResponse(String str) {
            jokeTextData.error();
          }
        });*/
  }
}
