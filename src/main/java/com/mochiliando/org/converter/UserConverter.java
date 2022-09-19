package com.mochiliando.org.converter;

import com.mochiliando.org.entity.UserEntity;
import com.mochiliando.org.model.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertEntityToDTO (UserEntity userEntity) {
        UserDTO userDTO = this.modelMapper.map(userEntity, UserDTO.class);
        userDTO.setPassword(null);
        return userDTO;

    }
}
