package com.guoami.retrofittest;

import retrofit2.Retrofit;

/**
 * Created by OBR on 2017/5/31.
 */

public class HttpMethods {

  public static final String BASE_URL = "http://www.sojson.com/open/api/lunar/";

  private static final int DEFAULT_TIMEOUT = 5;

  private Retrofit retrofit;
  private WeatherService weatherService;

  private HttpMethods() {
    okHttpClient.Builder httpClientBuilder = new okHttpClient.Builder();
  }
}
