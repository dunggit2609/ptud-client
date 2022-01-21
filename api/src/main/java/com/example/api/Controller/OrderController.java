package com.example.api.Controller;

import com.example.api.Interface.OrderRepository;
import com.example.api.DTO.OrderDetail;
import com.example.api.DTO.Order;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping(value = "/api/order")
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
    @PutMapping(value = "/api/nhandon/{id}")
    public Order NhanDon(@PathVariable("id") ObjectId id, @RequestBody Order order) {
       order.set_id(id);
       orderRepository.save(order);
       return order;
    }


}
