package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.order.OrderDto;
import com.kodilla.ecommercee.domain.order.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderEntity mapToOrder(final OrderDto orderDto) {
        return new OrderEntity(
                orderDto.getAdress()
        );
    }

    public OrderDto orderDtoToMap(final OrderEntity orderEntity) {
        return new OrderDto(
                orderEntity.getId(),
                orderEntity.getAdress(),
                orderEntity.getPaid(),
                orderEntity.getCreated()
        );
    }
}
