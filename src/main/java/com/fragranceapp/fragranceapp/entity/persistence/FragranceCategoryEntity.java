package com.fragranceapp.fragranceapp.entity.persistence;

import com.fragranceapp.fragranceapp.entity.enums.Category;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "categories", schema = "fragranceapp")
public class FragranceCategoryEntity {

    @Id
    @Column(name = "cat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Timestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(
            mappedBy = "fragranceCategoryEntity",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    private List<FragranceEntity> fragranceEntities;

    public FragranceCategoryEntity() {

    }

    public FragranceCategoryEntity(Category category) {
        this.category = category;
    }

    public FragranceCategoryEntity(Category category, List<FragranceEntity> fragranceEntities) {
        this.category = category;
        this.fragranceEntities = fragranceEntities;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<FragranceEntity> getFragranceEntities() {
        return fragranceEntities;
    }

    public void setFragranceEntities(List<FragranceEntity> fragranceEntities) {
        this.fragranceEntities = fragranceEntities;
    }

    @Override
    public String toString() {
        return "FragranceCategoryEntity{" +
                "id=" + id +
                ", category=" + category +
                ", fragranceEntities=" + fragranceEntities +
                '}';
    }
}
