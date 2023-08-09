package com.fragranceapp.fragranceapp.repository;

import com.fragranceapp.fragranceapp.entity.persistence.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findCustomerById(long customerId);

    @Query(value = "select * from fragranceapp.customers c " +
            "inner join fragranceapp.users u on c.user_id = u.usr_id " +
            "where u.email = :userEmail", nativeQuery = true)
    Optional<CustomerEntity> findCustomerByEmail(String userEmail);
}
