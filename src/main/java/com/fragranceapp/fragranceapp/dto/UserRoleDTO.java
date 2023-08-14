package com.fragranceapp.fragranceapp.dto;

import com.fragranceapp.fragranceapp.entity.enums.Role;

public class UserRoleDTO {

    private Role role;

    public UserRoleDTO() {

    }

    public UserRoleDTO(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
