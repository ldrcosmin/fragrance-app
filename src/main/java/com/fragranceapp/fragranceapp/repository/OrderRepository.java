package com.fragranceapp.fragranceapp.repository;

import com.fragranceapp.fragranceapp.entity.persistence.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Optional<OrderEntity> findOrderById(long orderId);

    @Query(value = "select * from fragranceapp.orders o " +
            "inner join fragranceapp.customers c on o.customer_id = c.cust_id " +
            "where c.cust_id = :customerId", nativeQuery = true)
    List<OrderEntity> findOrdersByCustomerId(long customerId);
}
