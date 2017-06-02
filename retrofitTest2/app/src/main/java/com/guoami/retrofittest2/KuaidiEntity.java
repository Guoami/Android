package com.guoami.retrofittest2;

import java.util.List;

/**
 * Created by OBR on 2017/6/2.
 */

public class KuaidiEntity {

  private String nu;
  private String com;
  public String message;
  private List<Data> data;

  public void setNu(String nu) {
    this.nu = nu;
  }

  public String getNu() {
    return this.nu;
  }

  public void setCom(String com) {
    this.com = com;
  }

  public String getCom() {
    return this.com;
  }

  public String getMessage() {
    return message;
  }

  public void setData(List<Data> data) {
    this.data = data;
  }

  public List<Data> getData() {
    return this.data;
  }

}
