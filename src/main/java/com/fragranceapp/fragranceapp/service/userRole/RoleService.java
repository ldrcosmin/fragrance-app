package com.fragranceapp.fragranceapp.service.userRole;

import com.fragranceapp.fragranceapp.dto.UserRoleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    UserRoleDTO createRole(UserRoleDTO newRole);
    List<UserRoleDTO> getAllRoles();
    UserRoleDTO getRoleById(long roleId);
    UserRoleDTO updateRole(long roleId, UserRoleDTO updateRole);
    void deleteRole(long roleId);
}
