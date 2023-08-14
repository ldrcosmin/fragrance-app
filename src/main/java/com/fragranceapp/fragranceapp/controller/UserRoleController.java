package com.fragranceapp.fragranceapp.controller;

import com.fragranceapp.fragranceapp.dto.UserRoleDTO;
import com.fragranceapp.fragranceapp.service.userRole.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class UserRoleController {

    private RoleServiceImpl roleService;

    @Autowired
    public UserRoleController(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRoleDTO> getRole(@PathVariable long id) {
        UserRoleDTO userRoleDTO = roleService.getRoleById(id);

        return new ResponseEntity<>(userRoleDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserRoleDTO>> getAllRoles() {
        List<UserRoleDTO> userRoleDTOS = roleService.getAllRoles();

        return new ResponseEntity<>(userRoleDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserRoleDTO> createRole(@RequestBody UserRoleDTO newRole) {
        UserRoleDTO userRoleDTO = roleService.createRole(newRole);

        return new ResponseEntity<>(userRoleDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRoleDTO> updateRole(@PathVariable long id, @RequestBody UserRoleDTO updateRole) {
        UserRoleDTO userRoleDTO = roleService.updateRole(id, updateRole);

        return new ResponseEntity<>(updateRole, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserRoleDTO> deleteRole(@PathVariable long id) {
        roleService.deleteRole(id);

        return ResponseEntity.ok().build();
    }
}
