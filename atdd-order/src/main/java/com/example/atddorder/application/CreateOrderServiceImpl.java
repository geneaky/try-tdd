package com.example.atddorder.application;

import com.example.atddorder.domain.PendingOrder;
import com.example.atddorder.domain.PendingOrderRepository;
import org.springframework.stereotype.Service;

@Service
class CreateOrderServiceImpl implements CreateOrderService {

  private final PendingOrderRepository pendingOrderRepository;

  public CreateOrderServiceImpl(
      PendingOrderRepository pendingOrderRepository) {
    this.pendingOrderRepository = pendingOrderRepository;
  }

  @Override
  public PendingOrder createPendingOrder(PendingOrderRequest request) {
    PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
    return pendingOrderRepository.save(pendingOrder);
  }
}
