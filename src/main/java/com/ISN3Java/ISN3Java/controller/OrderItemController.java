package com.ISN3Java.ISN3Java.controller;

import com.ISN3Java.ISN3Java.dto.OrderItemDTO;
import com.ISN3Java.ISN3Java.model.OrderItemEntity;
import com.ISN3Java.ISN3Java.repository.OrderItemRepository;
import com.ISN3Java.ISN3Java.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ModelMapperService modelMapperService;

    @GetMapping
    public List<OrderItemDTO> getAllOrderItems() {
        List<OrderItemEntity> orderItems = orderItemRepository.findAll();
        return modelMapperService.convertToDtoList(orderItems, OrderItemDTO.class);
    }

    @GetMapping("/{id}")
    public OrderItemDTO getOrderItemById(@PathVariable Long id) {
        OrderItemEntity orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));
        return modelMapperService.convertToDto(orderItem);
    }

    @PostMapping
    public OrderItemDTO createOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        OrderItemEntity orderItemEntity = modelMapperService.convertToEntity(orderItemDTO);
        OrderItemEntity savedOrderItem = orderItemRepository.save(orderItemEntity);
        return modelMapperService.convertToDto(savedOrderItem);
    }

    @PutMapping("/{id}")
    public OrderItemDTO updateOrderItem(@PathVariable Long id, @RequestBody OrderItemDTO orderItemDTO) {
        OrderItemEntity orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));

        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setPrice(orderItemDTO.getPrice());
        // За ъпдейт на product или order – зареди ги по ID и сетни ги тук.

        OrderItemEntity updatedOrderItem = orderItemRepository.save(orderItem);
        return modelMapperService.convertToDto(updatedOrderItem);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable Long id) {
        orderItemRepository.deleteById(id);
    }
}
