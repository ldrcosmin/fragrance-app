package com.fragranceapp.fragranceapp.controller;

import com.fragranceapp.fragranceapp.dto.CategoryDTO;
import com.fragranceapp.fragranceapp.dto.FragranceDTO;
import com.fragranceapp.fragranceapp.dto.OrderDTO;
import com.fragranceapp.fragranceapp.service.fragrance.FragranceService;
import com.fragranceapp.fragranceapp.service.fragranceCategory.FragranceCategoryService;
import com.fragranceapp.fragranceapp.service.order.OrderService;
import com.fragranceapp.fragranceapp.service.userRole.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private RoleService roleService;
    private OrderService orderService;
    private FragranceService fragranceService;
    private FragranceCategoryService fragranceCategoryService;

    @Autowired
    public UserController(RoleService roleService,
                          OrderService orderService,
                          FragranceService fragranceService,
                          FragranceCategoryService fragranceCategoryService) {
        this.roleService = roleService;
        this.orderService = orderService;
        this.fragranceService = fragranceService;
        this.fragranceCategoryService = fragranceCategoryService;
    }


    @PostMapping("/orders")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO newOrder) {
        OrderDTO orderDTO = orderService.createOrder(newOrder);

        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity cancelOrder(@PathVariable long id) {
        orderService.cancelOrder(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/fragrances/{id}")
    public ResponseEntity<FragranceDTO> getFragrance(@PathVariable long id) {
        FragranceDTO fragranceDTO = fragranceService.getFragranceById(id);

        return new ResponseEntity<>(fragranceDTO, HttpStatus.OK);
    }

    @GetMapping("/fragrances")
    public ResponseEntity<List<FragranceDTO>> getAllFragrances() {
        List<FragranceDTO> fragranceDTOS = fragranceService.getAllFragrances();

        return new ResponseEntity<>(fragranceDTOS, HttpStatus.OK);
    }

    @GetMapping("/fragrances/categories/{id}")
    public ResponseEntity<List<FragranceDTO>> getAllFragrancesByCategory(@PathVariable long id) {
        List<FragranceDTO> fragranceDTOS = fragranceService.getAllFragrancesByCategoryId(id);

        return new ResponseEntity<>(fragranceDTOS, HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable long id) {
        CategoryDTO categoryDTO = fragranceCategoryService.getCategoryById(id);

        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
       List<CategoryDTO> categories =  fragranceCategoryService.getAllCategories();

       return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
