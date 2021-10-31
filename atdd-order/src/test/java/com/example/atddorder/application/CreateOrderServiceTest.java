package com.example.atddorder.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.atddorder.domain.PendingOrder;
import com.example.atddorder.domain.PendingOrderRepository;
import com.example.atddorder.infra.PendingOrderRepositoryMemoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateOrderServiceTest {

  private PendingOrderRepository pendingOrderRepository = new PendingOrderRepositoryMemoryImpl();
  private CreateOrderService createOrderService = new CreateOrderServiceImpl(
      pendingOrderRepository);

  @Test
  @DisplayName("createPendingOrder")
  public void createPendingOrder() throws Exception {
    Long productid = 1l;
    int quantity = 2;
    PendingOrderRequest request = PendingOrderRequest.of(productid, quantity);

    PendingOrder pendingOrder = createOrderService.createPendingOrder(request);
    assertThat(pendingOrder.getId()).isPositive();
  }

}
