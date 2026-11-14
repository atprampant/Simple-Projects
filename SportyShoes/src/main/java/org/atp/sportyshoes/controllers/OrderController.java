package org.atp.sportyshoes.controllers;

import org.atp.sportyshoes.dto.OrderItemsDto;
import org.atp.sportyshoes.entities.Orders;
import org.atp.sportyshoes.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sportyshoes/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("")
    public ResponseEntity<Orders> createAnOrder(@RequestBody OrderItemsDto orderItemsDto){
        Orders orders=orderService.createOrUpdateAnOrder(orderItemsDto);
        return new ResponseEntity<Orders>(orders, HttpStatus.OK);
    }
}
