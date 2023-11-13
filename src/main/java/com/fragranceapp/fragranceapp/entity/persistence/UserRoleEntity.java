package com.fragranceapp.fragranceapp.entity.persistence;

import com.fragranceapp.fragranceapp.entity.enums.Role;
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
@Table(name = "roles", schema = "fragranceapp")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserRoleEntity {

    @Id
    @Column(name = "rol_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Timestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @OneToMany(
            mappedBy = "role",
            fetch = FetchType.LAZY
    )
    private List<UserEntity> users;

}
