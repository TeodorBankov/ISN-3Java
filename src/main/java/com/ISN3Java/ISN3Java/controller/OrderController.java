package com.ISN3Java.ISN3Java.controller;

import com.ISN3Java.ISN3Java.dto.OrderDTO;
import com.ISN3Java.ISN3Java.model.OrderEntity;
import com.ISN3Java.ISN3Java.repository.OrderRepository;
import com.ISN3Java.ISN3Java.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapperService modelMapperService;

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        List<OrderEntity> orders = orderRepository.findAll();
        return modelMapperService.convertToDtoList(orders, OrderDTO.class);
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return modelMapperService.convertToDto(order);
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        OrderEntity orderEntity = modelMapperService.convertToEntity(orderDTO);
        OrderEntity savedOrder = orderRepository.save(orderEntity);
        return modelMapperService.convertToDto(savedOrder);
    }

    @PutMapping("/{id}")
    public OrderDTO updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setOrderDate(orderDTO.getOrderDate());
        // Ако искаш да ъпдейтваш потребител, зареди UserEntity по orderDTO.getUserId() и сетни order.setUser(...)
        // Същото важи за orderItems, ако искаш да ги ъпдейтваш.

        OrderEntity updatedOrder = orderRepository.save(order);
        return modelMapperService.convertToDto(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }
}
