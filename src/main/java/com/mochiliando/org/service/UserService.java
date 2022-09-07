package com.mochiliando.org.service;

import com.mochiliando.org.model.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO registerUser(UserDTO userDTO);
    UserDTO login(String email, String password);
    List<UserDTO> getAllUsers();

}
