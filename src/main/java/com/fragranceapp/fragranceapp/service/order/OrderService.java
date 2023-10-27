package com.fragranceapp.fragranceapp.service.order;

import com.fragranceapp.fragranceapp.dto.OrderDTO;
import java.util.List;

public interface OrderService {

    OrderDTO createOrder(OrderDTO newOrder);
    List<OrderDTO> getOrdersByUserId(long userId);
    OrderDTO getOrderById(long orderId);
    void cancelOrder(long orderId);
}
