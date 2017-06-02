package com.guoami.retrofittest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    getKuaidi();
  }

  private void getKuaidi() {
    String url = "http://www.kuaidi100.com/";
    String type = "yunda";
    String postid = "3936341803585";

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();

    KuaidiService kuaidiService = retrofit.create(KuaidiService.class);

    kuaidiService.getKuaidiData(type, postid)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<KuaidiEntity>() {
          @Override public void onCompleted() {
          }

          @Override public void onError(Throwable e) {
            result.setText(e.getMessage());
          }

          @Override public void onNext(KuaidiEntity kuaidiEntity) {
            result.setText(kuaidiEntity.getData()+"");
          }
        });
  }
}
