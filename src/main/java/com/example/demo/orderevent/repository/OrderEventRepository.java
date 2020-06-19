package com.example.demo.orderevent.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ppe.emailservice.orderevent.entity.OrderEventEntity;


public interface OrderEventRepository extends CrudRepository<OrderEventEntity, Long> {

    List<OrderEventEntity> findByOrderconsumedFalse();
    List<OrderEventEntity> findByInventoryconsumedFalse();
    List<OrderEventEntity> findByEmailconsumedFalse();
}
