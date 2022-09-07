package com.mochiliando.org.service.impl;

import com.mochiliando.org.converter.UserConverter;
import com.mochiliando.org.entity.UserEntity;
import com.mochiliando.org.model.dto.UserDTO;
import com.mochiliando.org.repository.UserRepository;
import com.mochiliando.org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        return userConverter.convertEntityToDTO(userEntity);
    }

    @Override
    public UserDTO login(String email, String password) {
      return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOS = new ArrayList<>();

        userRepository.findAll().forEach((UserEntity userEntity) ->
                userDTOS.add(userConverter.convertEntityToDTO(userEntity)));

        return userDTOS;
    }
}