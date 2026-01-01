package com.example.ECommerce.Service;

import com.example.ECommerce.Dto.UserDto;
import com.example.ECommerce.Entities.Userr;
import com.example.ECommerce.Entities.Userr;
import com.example.ECommerce.Exception.ResourceNotFoundException;
import com.example.ECommerce.Repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        Userr user=modelMapper.map(userDto, Userr.class);
        Userr createdUser=this.userRepo.save(user);
        return modelMapper.map(createdUser, UserDto.class);


    }

    @Override
    public UserDto getUserById(Integer userId) {
        Userr Userr=this.userRepo.findById(userId).get();
        return modelMapper.map(Userr, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<Userr> users=this.userRepo.findAll();
        return users.stream().map(user1->modelMapper.map(user1, UserDto.class)).toList();
    }

    @Override
    public UserDto updateUserById(UserDto userDto, Integer userId) {
        Userr Userr=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","userId",userId));
        Userr.setUserName(userDto.getUserName());
        Userr.setUserEmail(userDto.getUserEmail());
        this.userRepo.save(Userr);
        return modelMapper.map(Userr, UserDto.class);
    }

    @Override
    public void deleteUser(Integer userId) {
        Userr Userr=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException(
                "Userr"," id", userId
        ));

        this.userRepo.delete(Userr);
    }
}
