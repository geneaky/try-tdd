package com.example.atddorder.infra;

import com.example.atddorder.domain.PendingOrder;
import com.example.atddorder.domain.PendingOrderRepository;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class PendingOrderRepositoryMemoryImpl implements PendingOrderRepository {

  private AtomicLong atomicLong = new AtomicLong(1);

  @Override
  public PendingOrder save(PendingOrder pendingOrder) {
    pendingOrder.assignId(nextId());
    return pendingOrder;
  }

  private long nextId() {
    return atomicLong.getAndIncrement();
  }
}
