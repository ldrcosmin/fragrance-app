package com.fragranceapp.fragranceapp.entity.persistence;

import com.fragranceapp.fragranceapp.entity.enums.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users", schema = "fragranceapp")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;

    @CreationTimestamp
    private LocalDateTime usr_created_at;

    @UpdateTimestamp
    private LocalDateTime usr_updated_at;

    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(
            mappedBy = "userEntity",
            fetch = FetchType.LAZY ,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    private AdministratorEntity administratorEntity;

    @OneToOne(
            mappedBy = "userEntity",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    private CustomerEntity customerEntity;

    public UserEntity() {

    }

    public UserEntity(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public LocalDateTime getUsr_created_at() {
        return usr_created_at;
    }

    public void setUsr_created_at(LocalDateTime usr_created_at) {
        this.usr_created_at = usr_created_at;
    }

    public LocalDateTime getUsr_updated_at() {
        return usr_updated_at;
    }

    public void setUsr_updated_at(LocalDateTime usr_updated_at) {
        this.usr_updated_at = usr_updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return usr_created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.usr_created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return usr_updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.usr_updated_at = updated_at;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public AdministratorEntity getAdministratorEntity() {
        return administratorEntity;
    }

    public void setAdministratorEntity(AdministratorEntity administratorEntity) {
        this.administratorEntity = administratorEntity;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", created_at=" + usr_created_at +
                ", updated_at=" + usr_updated_at +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
