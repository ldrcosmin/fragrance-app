package com.fragranceapp.fragranceapp.mapper;

import com.fragranceapp.fragranceapp.dto.CategoryDTO;
import com.fragranceapp.fragranceapp.dto.FragranceDTO;
import com.fragranceapp.fragranceapp.dto.OrderDTO;
import com.fragranceapp.fragranceapp.entity.persistence.FragranceCategoryEntity;
import com.fragranceapp.fragranceapp.entity.persistence.FragranceEntity;
import com.fragranceapp.fragranceapp.entity.persistence.OrderEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Mapper {


    public static CategoryDTO categoryToDto(FragranceCategoryEntity fragranceCategoryEntity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategory(fragranceCategoryEntity.getCategory());

        return categoryDTO;
    }

    public static FragranceCategoryEntity dtoToCategory(CategoryDTO categoryDTO) {
        FragranceCategoryEntity fragranceCategoryEntity = new FragranceCategoryEntity();
        fragranceCategoryEntity.setCategory(categoryDTO.getCategory());
        fragranceCategoryEntity.setCreated_at(LocalDateTime.now());
        fragranceCategoryEntity.setUpdated_at(LocalDateTime.now());

        return fragranceCategoryEntity;
    }

    public static FragranceDTO fragranceToDto(FragranceEntity fragranceEntity) {
        FragranceDTO fragranceDTO = new FragranceDTO();
        fragranceDTO.setName(fragranceEntity.getName());
        fragranceDTO.setAmount(fragranceEntity.getAmount());
        fragranceDTO.setQuantity(fragranceEntity.getQuantity());
        fragranceDTO.setPrice(fragranceEntity.getPrice());

        return fragranceDTO;
    }

    public static FragranceEntity dtoToFragrance(FragranceDTO fragranceDTO) {
        FragranceEntity fragranceEntity = new FragranceEntity();
        fragranceEntity.setName(fragranceDTO.getName());
        fragranceEntity.setAmount(fragranceDTO.getAmount());
        fragranceEntity.setQuantity(fragranceDTO.getQuantity());
        fragranceEntity.setPrice(fragranceDTO.getPrice());

        return fragranceEntity;
    }

    public static OrderDTO orderToDto(OrderEntity orderEntity) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setInfo(orderEntity.getInfo());
        orderDTO.setValue(orderEntity.getValue());

        return orderDTO;
    }

    public static OrderEntity dtoToOrder(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setInfo(orderDTO.getInfo());
        orderEntity.setValue(orderDTO.getValue());

        return orderEntity;
    }


}
