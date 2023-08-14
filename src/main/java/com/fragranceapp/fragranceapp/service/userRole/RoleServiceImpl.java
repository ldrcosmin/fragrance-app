package com.fragranceapp.fragranceapp.service.userRole;

import com.fragranceapp.fragranceapp.dto.UserRoleDTO;
import com.fragranceapp.fragranceapp.entity.persistence.UserRoleEntity;
import com.fragranceapp.fragranceapp.exceptions.roleExceptions.RoleNotFoundException;
import com.fragranceapp.fragranceapp.mapper.Mapper;
import com.fragranceapp.fragranceapp.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private UserRoleRepository userRoleRepository;

    @Autowired
    public RoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRoleDTO createRole(UserRoleDTO newRole) {
        UserRoleEntity userRoleEntity = Mapper.dtoToRole(newRole);
        userRoleRepository.save(userRoleEntity);

        return newRole;
    }

    @Override
    public List<UserRoleDTO> getAllRoles() {
        List<UserRoleEntity> roles = userRoleRepository.findAll();
        List<UserRoleDTO> roleDTOS = roles.stream()
                .map(entity -> Mapper.roleToDto(entity))
                .collect(Collectors.toList());

        return roleDTOS;
    }

    @Override
    public UserRoleDTO getRoleById(long roleId) {
        Optional<UserRoleEntity> role = userRoleRepository.findRoleById(roleId);
        if(role.isEmpty()) {
            throw new RoleNotFoundException("The role with id " + roleId + " doesn't exist");
        }
        return Mapper.roleToDto(role.get());
    }

    @Override
    public UserRoleDTO updateRole(long roleId, UserRoleDTO updateRole) {
        Optional<UserRoleEntity> role = userRoleRepository.findRoleById(roleId);
        if(role.isEmpty()) {
            throw new RoleNotFoundException("The role with id " + roleId + " doesn't exist");
        }
        role.get().setRole(updateRole.getRole());
        userRoleRepository.save(role.get());

        return Mapper.roleToDto(role.get());
    }

    @Override
    public void deleteRole(long roleId) {
        Optional<UserRoleEntity> role = userRoleRepository.findRoleById(roleId);
        if(role.isEmpty()) {
            throw new RoleNotFoundException("The role with id " + roleId + " doesn't exist");
        }
        userRoleRepository.deleteById(roleId);
    }
}

