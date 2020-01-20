package com.kodilla.ecommercee.controller.order;

import com.kodilla.ecommercee.controller.user.UserNotFoundException;
import com.kodilla.ecommercee.domain.order.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @Autowired
    DbOrderService orderService;

    @Autowired
    OrderMapper orderMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getOrderList")
    public List<OrderDto> getOrdersList() {
        return orderMapper.mapToOrderDtoList(orderService.getOrders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) throws OrderNotFoundException {
        return orderMapper.orderDtoToMap(orderService.getOrder(orderId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createNewOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto createNewOrder(@RequestBody OrderDto orderDto) throws UserNotFoundException {
        return orderMapper.orderDtoToMap(orderService.saveOrder(orderMapper.mapToOrder(orderDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) throws UserNotFoundException {
        return orderMapper.orderDtoToMap(orderService.saveOrder(orderMapper.mapToOrder(orderDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
