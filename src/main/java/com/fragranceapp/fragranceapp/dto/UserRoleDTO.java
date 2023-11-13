package com.fragranceapp.fragranceapp.dto;

import com.fragranceapp.fragranceapp.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDTO {

    private Role role;


}
