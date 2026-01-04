package com.example.ECommerce.Service;

import com.example.ECommerce.Dto.UserDto;
import com.example.ECommerce.Entities.Userr;

import java.util.*;


public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    UserDto updateUserById(UserDto userDto, Integer userId);

    void deleteUser(Integer userId);

    Userr getUserByUserName(String userName);
}
