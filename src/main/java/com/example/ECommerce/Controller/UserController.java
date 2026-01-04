package com.example.ECommerce.Controller;


import com.example.ECommerce.Dto.UserDto;
import com.example.ECommerce.Entities.Userr;
import com.example.ECommerce.Response.ApiResponse;
import com.example.ECommerce.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.time.*;
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUser=this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserDto> getUserByID(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUser(){

        return ResponseEntity.ok(this.userService.getAllUsers());

    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer userId, @RequestBody UserDto userDto){
         UserDto updatedUser=this.userService.updateUserById(userDto,userId);
         return  ResponseEntity.ok(updatedUser);


    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<ApiResponse> deleteUserById(@PathVariable Integer userId){
        this.userService.deleteUser(userId);
        return  ResponseEntity.ok(new ApiResponse("User Deleted Successfully",true,LocalDateTime.now()));


    }

    @GetMapping("/userName/{userName}")
    Userr getByUserName(@PathVariable String userName){
        return this.userService.getUserByUserName(userName);
    }


}
