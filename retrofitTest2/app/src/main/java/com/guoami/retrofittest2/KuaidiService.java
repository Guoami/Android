package com.guoami.retrofittest2;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by OBR on 2017/6/2.
 */

public interface KuaidiService {

  @GET("query")
  Observable<KuaidiEntity> getKuaidiData(@Query("type") String type,@Query("postid") String postid);
}
