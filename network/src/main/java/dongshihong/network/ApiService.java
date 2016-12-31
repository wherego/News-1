package dongshihong.network;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Dsh on 2016/12/27
 */

public class ApiService {
  private static final CallAdapter.Factory rxJavaCallAdapterFactory =
      RxJavaCallAdapterFactory.create();

  private static Retrofit getRetrofit() {

    return new Retrofit.Builder().client(
        new OkHttpClient.Builder().addInterceptor(new LogInterceptor()).build())
        .baseUrl("http://apis.baidu.com/")
        .addConverterFactory(JacksonConverterFactory.create())
        .addCallAdapterFactory(rxJavaCallAdapterFactory)
        .build();
  }

  private static class LogInterceptor implements Interceptor {
    @Override public okhttp3.Response intercept(Chain chain) throws IOException {
      Request request = chain.request();
      okhttp3.Response response = chain.proceed(chain.request());
      okhttp3.MediaType mediaType = response.body().contentType();
      String content = response.body().string();
      if (response.body() != null) {
        ResponseBody body = ResponseBody.create(mediaType, content);
        return response.newBuilder().body(body).build();
      } else {
        return response;
      }
    }
  }

  public <T> T createApiService(Class<T> apiService) {
    return getRetrofit().create(apiService);
  }
}
