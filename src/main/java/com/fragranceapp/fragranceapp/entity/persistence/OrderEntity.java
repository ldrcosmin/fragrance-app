package com.fragranceapp.fragranceapp.entity.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToMany
    @JoinTable(
            name = "order_fragrance",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "ord_id"),
            inverseJoinColumns = @JoinColumn(name = "fragrance_id", referencedColumnName = "frag_id")
    )
    private List<FragranceEntity> content;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public OrderEntity() {

    }

    public OrderEntity(String info, double value, List<FragranceEntity> content, UserEntity userEntity) {
        this.info = info;
        this.value = value;
        this.content = content;
        this.userEntity = userEntity;
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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
