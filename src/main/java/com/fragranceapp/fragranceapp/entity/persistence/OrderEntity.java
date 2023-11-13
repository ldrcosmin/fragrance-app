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
import java.util.List;

@Entity
@Table(name = "orders", schema = "fragranceapp")
@Getter
@Setter
@NoArgsConstructor
@ToString
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

}
