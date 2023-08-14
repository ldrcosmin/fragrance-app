package com.fragranceapp.fragranceapp.entity.persistence;

import com.fragranceapp.fragranceapp.entity.enums.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

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
    private String name;
    private String phoneNumber;
    private String address;

    @OneToMany(
            mappedBy = "userEntity",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    private Set<OrderEntity> orders;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRoleEntity role;

    public UserEntity() {

    }

    public UserEntity(String email,
                      String password,
                      String name,
                      String phoneNumber,
                      String address,
                      Set<OrderEntity> orders,
                      UserRoleEntity role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orders = orders;
        this.role = role;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public UserRoleEntity getRole() {
        return role;
    }

    public void setRole(UserRoleEntity role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

