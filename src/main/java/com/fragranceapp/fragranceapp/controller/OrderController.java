package com.fragranceapp.fragranceapp.controller;

import com.fragranceapp.fragranceapp.dto.OrderDTO;
import com.fragranceapp.fragranceapp.service.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable long orderId) {
        OrderDTO order = orderService.getOrderById(orderId);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<List<OrderDTO>> getOrdersByCustomerId(@PathVariable(name = "id") long userId) {
        List<OrderDTO> orders = orderService.getOrdersByUserId(userId);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO newOrder) {
        OrderDTO orderDTO = orderService.createOrder(newOrder);

        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity cancelOrder(@PathVariable long orderId) {
        orderService.cancelOrder(orderId);

        return ResponseEntity.ok().build();
    }
}
