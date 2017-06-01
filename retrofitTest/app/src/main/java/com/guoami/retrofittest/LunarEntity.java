package com.guoami.retrofittest;

public class LunarEntity {

  //private String com;
  //private String state;
  //private String type;
  //private String postid;
  //
  //public String getType() {
  //  return type;
  //}
  //
  //public void setType(String type) {
  //  this.type = type;
  //}
  //
  //public String getPostid() {
  //  return postid;
  //}
  //
  //public void setPostid(String postid) {
  //  this.postid = postid;
  //}
  //
  //public String getCom() {
  //  return com;
  //}
  //
  //public String getState() {
  //  return state;
  //}

  //@Override
  //public String toString() {
  //  StringBuffer sb = new StringBuffer();
  //  sb.append( " type=" + type + " postid=" + postid);
  //  return sb.toString();
  //}

  private String year;
  private String month;
  private String day;

  private String lunarYear;
  private String lunarMonth;
  private String lunarDay;
  private String cyclicalYear;
  private String cyclicalMonth;
  private String cyclicalDay;

  public void setYear(String year) {
    this.year = year;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public String getLunarYear() {
    return lunarYear;
  }

  public String getLunarMonth() {
    return lunarMonth;
  }

  public String getLunarDay() {
    return lunarDay;
  }

  public String getCyclicalYear() {
    return cyclicalYear;
  }

  public String getCyclicalMonth() {
    return cyclicalMonth;
  }

  public String getCyclicalDay() {
    return cyclicalDay;
  }
}
