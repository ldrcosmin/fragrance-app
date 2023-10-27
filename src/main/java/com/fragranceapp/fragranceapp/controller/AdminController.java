package com.fragranceapp.fragranceapp.controller;

import com.fragranceapp.fragranceapp.dto.*;
import com.fragranceapp.fragranceapp.service.fragrance.FragranceService;
import com.fragranceapp.fragranceapp.service.fragranceCategory.FragranceCategoryService;
import com.fragranceapp.fragranceapp.service.order.OrderService;
import com.fragranceapp.fragranceapp.service.user.UserService;
import com.fragranceapp.fragranceapp.service.userRole.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private RoleService roleService;
    private OrderService orderService;
    private FragranceService fragranceService;
    private FragranceCategoryService fragranceCategoryService;
    private UserService userService;

    @Autowired
    public AdminController(RoleService roleService,
                           OrderService orderService,
                           FragranceService fragranceService,
                           FragranceCategoryService fragranceCategoryService,
                           UserService userService) {
        this.roleService = roleService;
        this.orderService = orderService;
        this.fragranceService = fragranceService;
        this.fragranceCategoryService = fragranceCategoryService;
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<String> signupAdmin(@RequestBody UserDTO newUser) {
        UserDTO userDTO = userService.createUser(newUser);

        return new ResponseEntity<>("Account successfully created!", HttpStatus.CREATED);
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<UserRoleDTO> getRole(@PathVariable long id) {
        UserRoleDTO userRoleDTO = roleService.getRoleById(id);

        return new ResponseEntity<>(userRoleDTO, HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<UserRoleDTO>> getAllRoles() {
        List<UserRoleDTO> userRoleDTOS = roleService.getAllRoles();

        return new ResponseEntity<>(userRoleDTOS, HttpStatus.OK);
    }

    @PostMapping("/roles")
    public ResponseEntity<UserRoleDTO> createRole(@RequestBody UserRoleDTO newRole) {
        UserRoleDTO userRoleDTO = roleService.createRole(newRole);

        return new ResponseEntity<>(userRoleDTO, HttpStatus.OK);
    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<UserRoleDTO> updateRole(@PathVariable long id, @RequestBody UserRoleDTO updateRole) {
        UserRoleDTO userRoleDTO = roleService.updateRole(id, updateRole);

        return new ResponseEntity<>(updateRole, HttpStatus.OK);
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity deleteRole(@PathVariable long id) {
        roleService.deleteRole(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable long id) {
       OrderDTO order = orderService.getOrderById(id);

       return new ResponseEntity<>(order, HttpStatus.OK);
   }

    @GetMapping("/orders/customer/{id}")
    public ResponseEntity<List<OrderDTO>> getOrdersByCustomerId(@PathVariable long id) {
        List<OrderDTO> orders = orderService.getOrdersByUserId(id);

        return new ResponseEntity<>(orders, HttpStatus.OK);
   }

    @PostMapping("/fragrances")
    public ResponseEntity<FragranceDTO> createFragrance(@RequestBody FragranceDTO fragranceDTO) {
        FragranceDTO fragrance = fragranceService.createFragrance(fragranceDTO);

        return new ResponseEntity<>(fragrance, HttpStatus.CREATED);
    }

    @PutMapping("/fragrances/{id}")
    public ResponseEntity<FragranceDTO> updateFragrance(@PathVariable long id, @RequestBody FragranceDTO updateFragrance) {
        FragranceDTO fragranceDTO = fragranceService.updateFragrance(id, updateFragrance);

        return new ResponseEntity(fragranceDTO, HttpStatus.OK);
    }

    @DeleteMapping("/fragrances/{id}")
    public ResponseEntity deleteFragrance(@PathVariable long id) {
        fragranceService.deleteFragrance(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO category = fragranceCategoryService.createCategory(categoryDTO);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable long id, @RequestBody CategoryDTO newCategory) {
        CategoryDTO categoryDTO = fragranceCategoryService.updateCategory(id, newCategory);

        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity deleteCategory(@PathVariable long id) {
        fragranceCategoryService.deleteCategory(id);

        return ResponseEntity.ok().build();
    }
}
