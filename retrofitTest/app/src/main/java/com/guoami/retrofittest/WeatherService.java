package com.guoami.retrofittest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by OBR on 2017/5/31.
 */

public interface WeatherService {

  @GET("lunar") Observable<WeatherEntity>
  getWeatherData(@Query("date") String date);
}
