package com.fragranceapp.fragranceapp.entity.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fragranceapp.fragranceapp.entity.persistence.UserEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "administrators", schema = "fragranceapp")
public class AdministratorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adm_id")
    private Long id;

    @CreationTimestamp
    private LocalDateTime adm_created_at;

    @UpdateTimestamp
    private LocalDateTime adm_updated_at;

    private String name;

    @Column(name = "phone")
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity userEntity;

    public AdministratorEntity() {

    }


    public AdministratorEntity(String name, String phoneNumber, UserEntity userEntity) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.userEntity = userEntity;
    }

    public LocalDateTime getAdm_created_at() {
        return adm_created_at;
    }

    public void setAdm_created_at(LocalDateTime adm_created_at) {
        this.adm_created_at = adm_created_at;
    }

    public LocalDateTime getAdm_updated_at() {
        return adm_updated_at;
    }

    public void setAdm_updated_at(LocalDateTime adm_updated_at) {
        this.adm_updated_at = adm_updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return adm_created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.adm_created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return adm_updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.adm_updated_at = updated_at;
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public String toString() {
        return "AdministratorEntity{" +
                "id=" + id +
                ", created_at=" + adm_created_at +
                ", updated_at=" + adm_updated_at +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userEntity=" + userEntity +
                '}';
    }
}
