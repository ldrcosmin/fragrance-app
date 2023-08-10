package com.fragranceapp.fragranceapp.service.order;

import com.fragranceapp.fragranceapp.dto.OrderDTO;
import com.fragranceapp.fragranceapp.entity.persistence.FragranceEntity;
import com.fragranceapp.fragranceapp.entity.persistence.OrderEntity;
import com.fragranceapp.fragranceapp.entity.persistence.UserEntity;
import com.fragranceapp.fragranceapp.exceptions.orderExceptions.CancelOrderException;
import com.fragranceapp.fragranceapp.exceptions.orderExceptions.OrderNotFoundException;
import com.fragranceapp.fragranceapp.exceptions.userExceptions.UserNotFoundException;
import com.fragranceapp.fragranceapp.mapper.Mapper;
import com.fragranceapp.fragranceapp.repository.FragranceRepository;
import com.fragranceapp.fragranceapp.repository.OrderRepository;
import com.fragranceapp.fragranceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private FragranceRepository fragranceRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            UserRepository userRepository,
                            FragranceRepository fragranceRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.fragranceRepository = fragranceRepository;
    }

    @Override
    public OrderDTO createOrder(OrderDTO newOrder) {
        OrderEntity orderEntity = Mapper.dtoToOrder(newOrder);
        List<FragranceEntity> fragrances = fragranceRepository.findByIdIn(newOrder.getContent());
        Optional<UserEntity> user = userRepository.findUserById(newOrder.getUserId());
        if(user.isEmpty()) {
            throw new UserNotFoundException("The user with id " + newOrder.getUserId() + " doesn't exist");
        }
        double value = Double.MIN_VALUE;
        for(FragranceEntity fragrance : fragrances){
            value = value + fragrance.getPrice();
        }
        orderEntity.setContent(fragrances);
        orderEntity.setUserEntity(user.get());
        orderEntity.setValue(value);
        orderRepository.save(orderEntity);

        return Mapper.orderToDto(orderEntity);
    }

    @Override
    public List<OrderDTO> getOrdersByUserId(long userId) {
        List<OrderEntity> orders = orderRepository.findOrdersByUserId(userId);
        List<OrderDTO> orderDTOS = orders.stream()
                .map(entity -> Mapper.orderToDto(entity))
                .collect(Collectors.toList());

        return orderDTOS;
    }

    @Override
    public OrderDTO getOrderById(long orderId) {
        Optional<OrderEntity> order = orderRepository.findOrderById(orderId);
        if(order.isEmpty()) {
            throw new OrderNotFoundException("The order with id " + orderId + " doesn't exist");
        }

        return Mapper.orderToDto(order.get());
    }

    @Override
    public void cancelOrder(long orderId) {
        Optional<OrderEntity> order = orderRepository.findOrderById(orderId);
        if(order.isEmpty()) {
            throw new OrderNotFoundException("The order with id " + orderId + " doesn't exist");
        }
        LocalDateTime orderTime = order.get().getCreated_at();
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(orderTime, now);
        if(duration.toMinutes() > 10) {
            throw new CancelOrderException("You cannot cancel the order, because passed more than 10 minutes");
        }

        orderRepository.deleteById(orderId);

    }
}
