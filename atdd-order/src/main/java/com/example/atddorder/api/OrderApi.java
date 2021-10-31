package com.example.atddorder.api;

import com.example.atddorder.application.CreateOrderService;
import com.example.atddorder.application.PendingOrderRequest;
import com.example.atddorder.application.PendingOrderResonse;
import com.example.atddorder.domain.PendingOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderApi {

  private final CreateOrderService createOrderService;

  public OrderApi(CreateOrderService createOrderService) {
    this.createOrderService = createOrderService;
  }

  @PostMapping("orders/pendingOrder")
  public ResponseEntity<PendingOrderResonse> createPendingOrder(
      @RequestBody PendingOrderRequest request) {
    PendingOrder pendingOrder = createOrderService.createPendingOrder(request);
    PendingOrderResonse reponse = new PendingOrderResonse(pendingOrder);
    return ResponseEntity.ok(reponse);
  }
}
