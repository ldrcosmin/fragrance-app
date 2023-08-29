package com.fragranceapp.fragranceapp.entity.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;


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

    public FragranceEntity() {

    }

    public FragranceEntity(String name,
                           String amount,
                           double price,
                           int quantity,
                           FragranceCategoryEntity fragranceCategoryEntity) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.quantity = quantity;
        this.fragranceCategoryEntity = fragranceCategoryEntity;
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
