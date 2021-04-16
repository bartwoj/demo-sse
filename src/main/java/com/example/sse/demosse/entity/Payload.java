package com.example.sse.demosse.entity;


public class Payload {
  protected String data;

  public Payload() {}

  public Payload(String data) {
    this.data = data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getData() {
    return data;
  }
}
