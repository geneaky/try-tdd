package com.example.atddorder.application;

import lombok.Getter;

@Getter
public class PendingOrderRequest {

  private long productId;
  private int quantity;

  public PendingOrderRequest(Long productid, int quantity) {
  }

  public static PendingOrderRequest of(Long productid, int quantity) {
    return new PendingOrderRequest(productid, quantity);
  }
}
