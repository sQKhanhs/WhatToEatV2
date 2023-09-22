package com.whattoeat.whattoeatv2.service;

import com.whattoeat.whattoeatv2.dto.UserDto;
import com.whattoeat.whattoeatv2.entity.User;

import java.util.List;

public interface IUserService {
    void saveUser(UserDto userDto);

    User findByLoginEmail();
    User findByEmail(String email);
    User findByUsername(String username);

    List<UserDto> findAllUsers();
}
