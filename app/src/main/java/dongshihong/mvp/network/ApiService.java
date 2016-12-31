package dongshihong.mvp.network;

/**
 * Created by Dsh on 2016/12/27
 */

public class ApiService {
  /*private volatile static ApiService INSTANCE;
  private OkHttpClient sOkHttpClient;
  private Retrofit sRetrofit;

  private ApiService(String baseUrl) {
    sRetrofit = getRetrofit(baseUrl);
  }

  public static ApiService getInstance() {
    if (INSTANCE == null) {
      synchronized (ApiService.class) {
        if (INSTANCE == null) {
          INSTANCE = new ApiService(BuildConfig.BASE_URL);
        }
      }
    }
    return INSTANCE;
  }

  private OkHttpClient getOkHttpClient() {
    if (sOkHttpClient == null) {
      synchronized (this) {
        if (sOkHttpClient == null) {
          OkHttpClient.Builder builder = new OkHttpClient.Builder();
          builder.connectTimeout(10, TimeUnit.SECONDS);
          builder.retryOnConnectionFailure(true);
          sOkHttpClient = builder.build();
        }
      }
    }
    return sOkHttpClient;
  }

  private Retrofit getRetrofit(String baseUrl) {
    if (sRetrofit == null) {
      synchronized (this) {
        if (sRetrofit == null) {
          sRetrofit = new Retrofit.Builder().addConverterFactory(JacksonConverterFactory.create())
              .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
              .baseUrl(baseUrl)
              .build();
        }
      }
    }
    return sRetrofit;
  }

  public <T> T createApiService(Class<T> apiService) {
    return sRetrofit.create(apiService);
  }*/
}
