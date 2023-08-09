package com.fragranceapp.fragranceapp.service.order;

import com.fragranceapp.fragranceapp.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {

    OrderDTO createOrder(OrderDTO newOrder);
    List<OrderDTO> getOrdersByCustomerId(long customerId);
    OrderDTO getOrderById(long orderId);
    void cancelOrder(long orderId);
}
