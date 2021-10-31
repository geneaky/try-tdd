package com.example.atddorder.application;

import com.example.atddorder.domain.PendingOrder;
import lombok.Getter;

@Getter
public class PendingOrderResonse {

  private long id;
  private long productId;
  private int quantity;

  public PendingOrderResonse(long productId, int quantity) {

  }

  public PendingOrderResonse(PendingOrder pendingOrder) {
    this.id = pendingOrder.getId();
    this.productId = pendingOrder.getProductId();
    this.quantity = pendingOrder.getQuantity();
  }
}
