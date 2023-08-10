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
            "inner join fragranceapp.users u on o.user_id = u.usr_id " +
            "where u.usr_id = :userId", nativeQuery = true)
    List<OrderEntity> findOrdersByUserId(long userId);
}
