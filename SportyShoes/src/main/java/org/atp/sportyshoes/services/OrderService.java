package org.atp.sportyshoes.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.atp.sportyshoes.exceptions.OrderNotFoundException;
import org.modelmapper.ModelMapper;
import org.atp.sportyshoes.dto.OrderItemsDto;
import org.atp.sportyshoes.entities.OrderItems;
import org.atp.sportyshoes.entities.Orders;
import org.atp.sportyshoes.entities.Shoes;
import org.atp.sportyshoes.entities.Users;
import org.atp.sportyshoes.enums.StatusCodes;
import org.atp.sportyshoes.repositories.OrderItemRepository;
import org.atp.sportyshoes.repositories.OrderRepository;
import org.atp.sportyshoes.repositories.ShoeRepository;
import org.atp.sportyshoes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    
    ModelMapper modelMapper=new ModelMapper();

    ObjectMapper objectMapper=new ObjectMapper();
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    ShoeRepository shoeRepository;

    @Autowired
    OrderItemRepository orderItemRepository;
    public Orders createOrUpdateAnOrder(OrderItemsDto orderItemsDto){
        Shoes shoe=shoeRepository.findById(Long.valueOf(orderItemsDto.getShoeId())).orElseThrow(()->new RuntimeException("Shoe not found"));
        Orders order=orderRepository.findById(Long.valueOf(orderItemsDto.getOrderId())).orElse(new Orders());
        OrderItems item=new OrderItems();
        item.setShoes(shoe);
        item.setQuantity(orderItemsDto.getQuantity());
        order.addOrderItems(item);
        Users user=userService.getUserByUsername(orderItemsDto.getUsername());
        order.setUser(user);
        shoe.setQuantityAvailable(shoe.getQuantityAvailable()-orderItemsDto.getQuantity());

            BigDecimal total=BigDecimal.ZERO;
            for(OrderItems item1:order.getItems())
            {
                total=total.add(item1.getShoes().getAmount().multiply(new BigDecimal(item.getQuantity())));
            }

        order.setTotalAmount(total);
        orderRepository.save(order);
        order.setLocalDate(order.getCreatedAt().toLocalDate());
        return orderRepository.save(order);

    }
//        Orders orders=modelMapper.map(order, Orders.class);
//        Users user=userRepository.findById(order.getUser().getId());
//        order.setUser(user);
//
//
//        List<Shoes> shoes1=order.getShoes();
//        List<Shoes> shoes= new ArrayList<>();
//        for (Shoes shoe:shoes1) {
//            long id=shoe.getShoeId();
//            Shoes shoes2=shoeRepository.findByShoeId(id);
//            shoes.add(shoes2);
//        }
//
//        double amount = 0;
//        for (Shoes shoe:shoes){
//            amount=amount+shoe.getAmount();
//        }
//        orders.setShoes(shoes);
//        orders.setTotalAmount(amount);
//        orderRepository.save(orders);
//        orders.setLocalDate(orders.getCreatedAt().toLocalDate());
//        return  orderRepository.save(orders);
//
//    }

    public Orders getAllByDate(LocalDate inputDate){
        Optional<Orders> order= Optional.ofNullable(orderRepository.findAllByLocalDate(inputDate));
        if(order.isEmpty()){
            throw new OrderNotFoundException(StatusCodes.ORDER_NOT_FOUND);
        }
        return order.get();
    }

    public List<Orders> getAllOrders(){
        return orderRepository.findAll();
    }
}
