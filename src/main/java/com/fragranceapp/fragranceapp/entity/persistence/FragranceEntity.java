package com.fragranceapp.fragranceapp.entity.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fragranceapp.fragranceapp.entity.enums.Category;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "fragrances", schema = "fragranceapp")
public class FragranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "frag_id")
    private long id;

    @CreationTimestamp
    private LocalDateTime frag_created_at;

    @UpdateTimestamp
    private LocalDateTime frag_updated_at;

    private String name;

    private String amount;

    private double price;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private FragranceCategoryEntity fragranceCategoryEntity;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "fragrances_orders",
            joinColumns = @JoinColumn(name = "frag_id"),
            inverseJoinColumns = @JoinColumn(name = "ord_id")

    )
    private Set<OrderEntity> orders;

    public FragranceEntity() {

    }

    public FragranceEntity(String name,
                           String amount,
                           double price,
                           int quantity,
                           FragranceCategoryEntity fragranceCategoryEntity,
                           Set<OrderEntity> orders) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.quantity = quantity;
        this.fragranceCategoryEntity = fragranceCategoryEntity;
        this.orders = orders;
    }

    public LocalDateTime getFrag_created_at() {
        return frag_created_at;
    }

    public void setFrag_created_at(LocalDateTime frag_created_at) {
        this.frag_created_at = frag_created_at;
    }

    public LocalDateTime getFrag_updated_at() {
        return frag_updated_at;
    }

    public void setFrag_updated_at(LocalDateTime frag_updated_at) {
        this.frag_updated_at = frag_updated_at;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return frag_created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.frag_created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return frag_updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.frag_updated_at = updated_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public FragranceCategoryEntity getFragranceCategoryEntity() {
        return fragranceCategoryEntity;
    }

    public void setFragranceCategoryEntity(FragranceCategoryEntity fragranceCategoryEntity) {
        this.fragranceCategoryEntity = fragranceCategoryEntity;
    }

    @Override
    public String toString() {
        return "FragranceEntity{" +
                "name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
