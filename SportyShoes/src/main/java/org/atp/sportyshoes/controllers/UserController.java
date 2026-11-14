package org.atp.sportyshoes.controllers;

import org.atp.sportyshoes.dto.CreateUserDto;
import org.atp.sportyshoes.entities.Users;
import org.atp.sportyshoes.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sportyshoes/user")
public class UserController {

    @Autowired
    UserService userService;

    ModelMapper modelMapper=new ModelMapper();

    @PostMapping("")
    public ResponseEntity<Users> createUser(@RequestBody CreateUserDto createUserDto) {
        return new ResponseEntity<Users>(userService.createUser(createUserDto), HttpStatus.CREATED);
    }


}
