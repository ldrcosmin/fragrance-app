package com.fragranceapp.fragranceapp.entity.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fragranceapp.fragranceapp.entity.persistence.CustomerEntity;
import com.fragranceapp.fragranceapp.entity.persistence.FragranceEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders", schema = "fragranceapp")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ord_id")
    private Long id;

    @CreationTimestamp
    private LocalDateTime ord_created_at;

    @UpdateTimestamp
    private LocalDateTime ord_updated_at;

    @Column(name = "order_info")
    private String info;

    @Column(name = "order_value")
    private double value;

    @ManyToMany(mappedBy = "orders",
                fetch = FetchType.LAZY
    )
    private List<FragranceEntity> content;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    public OrderEntity() {

    }

    public OrderEntity(String info, double value, List<FragranceEntity> content, CustomerEntity customerEntity) {
        this.info = info;
        this.value = value;
        this.content = content;
        this.customerEntity = customerEntity;
    }

    public LocalDateTime getOrd_created_at() {
        return ord_created_at;
    }

    public void setOrd_created_at(LocalDateTime ord_created_at) {
        this.ord_created_at = ord_created_at;
    }

    public LocalDateTime getOrd_updated_at() {
        return ord_updated_at;
    }

    public void setOrd_updated_at(LocalDateTime ord_updated_at) {
        this.ord_updated_at = ord_updated_at;
    }

    public List<FragranceEntity> getContent() {
        return content;
    }

    public void setContent(List<FragranceEntity> content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return ord_created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.ord_created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return ord_updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.ord_updated_at = updated_at;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", created_at=" + ord_created_at +
                ", updated_at=" + ord_updated_at +
                ", info='" + info + '\'' +
                ", value=" + value +
                ", orderContent=" + content +
                '}';
    }
}