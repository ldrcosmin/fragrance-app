package com.fragranceapp.fragranceapp.entity.persistence;

import com.fragranceapp.fragranceapp.entity.enums.Category;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "categories", schema = "fragranceapp")
@Getter
@Setter
@NoArgsConstructor
@ToString
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
            fetch = FetchType.LAZY
    )
    private List<FragranceEntity> fragranceEntities;

}
