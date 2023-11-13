package com.fragranceapp.fragranceapp.entity.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;


@Entity
@Table(name = "fragrances", schema = "fragranceapp")
@Getter
@Setter
@NoArgsConstructor
@ToString
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

}
