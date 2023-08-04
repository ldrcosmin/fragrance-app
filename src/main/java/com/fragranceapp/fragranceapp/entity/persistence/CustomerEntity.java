package com.fragranceapp.fragranceapp.entity.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers", schema = "fragranceapp")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long id;

    @CreationTimestamp
    private LocalDateTime cust_created_at;

    @UpdateTimestamp
    private LocalDateTime cust_updated_at;

    private String name;
    private String address;

    @Column(name = "phone")
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity userEntity;


    @OneToMany(mappedBy = "customerEntity",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    private Set<OrderEntity> orders;

    public CustomerEntity() {

    }

    public CustomerEntity(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public CustomerEntity(String name, String address, String phoneNumber, UserEntity userEntity) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userEntity = userEntity;
        this.orders = new HashSet<OrderEntity>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return cust_created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.cust_created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return cust_updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.cust_updated_at = updated_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

}
