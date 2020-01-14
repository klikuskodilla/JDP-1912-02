package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.order.OrderDto;
import com.kodilla.ecommercee.exception.OrderNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "getOrderList")
    public List<OrderDto> getOrdersList() {
        List<OrderDto> testOrderList = new ArrayList<>();
        testOrderList.add(new OrderDto(1L, "test adress", false, new Date()));
        return testOrderList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) throws OrderNotFoundException {
        return new OrderDto(2L, "testAddress2", true, new Date());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "createNewOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNewOrder(@RequestBody OrderDto orderDto) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(3, "testAddress3", false, new Date());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {

    }


}
