package com.example.ECommerce.Service;

import com.example.ECommerce.Dto.UserDto;

import java.util.*;


public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    UserDto updateUserById(UserDto userDto, Integer userId);

    void deleteUser(Integer userId);
}
