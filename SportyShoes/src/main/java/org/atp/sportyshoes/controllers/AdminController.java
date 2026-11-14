package org.atp.sportyshoes.controllers;

import org.atp.sportyshoes.dto.AdminLoginDto;
import org.atp.sportyshoes.dto.OrderSearchDto;
import org.atp.sportyshoes.entities.Admin;
import org.atp.sportyshoes.entities.Orders;
import org.atp.sportyshoes.entities.Shoes;
import org.atp.sportyshoes.entities.Users;
import org.atp.sportyshoes.repositories.AdminRepository;
import org.atp.sportyshoes.response.ApiResponse;
import org.atp.sportyshoes.services.AdminService;
import org.atp.sportyshoes.services.OrderService;
import org.atp.sportyshoes.services.ShoeService;
import org.atp.sportyshoes.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/sportyshoes/admin")
public class AdminController {

    private static final String LOGIN_SUCCESSFUL="Login Successful";
    private static final String LOGIN_FAILED="Username or password do not match";
    @Autowired
    AdminService adminService;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserService userService;

    @Autowired
    ShoeService shoeService;

    @Autowired
    OrderService orderService;
    ModelMapper modelMapper=new ModelMapper();

    @PostMapping("")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
        return new ResponseEntity<Admin>(adminService.createAdmin(admin), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginAdmin(@RequestBody AdminLoginDto adminLoginDto){
        boolean login=false;
        login= adminService.validateAdminLogin(adminLoginDto);
        if(login)
        {
            ApiResponse apiResponse=new ApiResponse(HttpStatus.OK,LOGIN_SUCCESSFUL);
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);}
        else
        {
            ApiResponse apiResponse=new ApiResponse(HttpStatus.BAD_REQUEST,LOGIN_FAILED);
            return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/order")
    public ResponseEntity<Orders> searchOrders(@RequestBody OrderSearchDto orderSearchDto) throws ParseException {
        return new ResponseEntity<Orders>(orderService.getAllByDate(orderSearchDto.getInputDate()),HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Users> getUserByUsername(@PathVariable String username){
        return new ResponseEntity<Users>(userService.getUserByUsername(username),HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Users> getUserByEmail(@PathVariable String email){
        return new ResponseEntity<Users>(userService.getUserByEmail(email),HttpStatus.OK);
    }

    @GetMapping("/shoes")
    public ResponseEntity<List<Shoes>> getAllShoes(){
        return new ResponseEntity<List<Shoes>>(shoeService.getAllShoes(),HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers(){
        return new ResponseEntity<List<Users>>(userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Orders>> getAllOrders(){
        return new ResponseEntity<List<Orders>>(orderService.getAllOrders(),HttpStatus.OK);
    }
}
