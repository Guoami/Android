package com.guoami.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

  @Bind(R.id.button1) Button clickMe;
  @Bind(R.id.result) TextView result;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.button1)
  public void onClick() {
    getWeather();
  }

  private void getWeather() {
    String baseUrl = "http://www.sojson.com/open/api/lunar/";

    Gson gson = new GsonBuilder()
        .setDateFormat("yyyy-MM-dd")
        .create();

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();

    WeatherService weatherService = retrofit.create(WeatherService.class);
    //TODO 传入的数据需要重新设置
    weatherService.getWeatherData("4324")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<WeatherEntity>() {
          @Override public void onCompleted() {
            Toast.makeText(MainActivity.this, "Get Weather", Toast.LENGTH_SHORT).show();
          }

          @Override public void onError(Throwable e) {
            result.setText(e.getMessage());
          }

          @Override public void onNext(WeatherEntity weatherEntity) {
            result.setText(weatherEntity.toString());
          }
        });
  }
}
