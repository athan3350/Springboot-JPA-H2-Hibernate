package com.mochiliando.org.service.impl;

import com.mochiliando.org.converter.UserConverter;
import com.mochiliando.org.entity.UserEntity;
import com.mochiliando.org.exception.BusinessException;
import com.mochiliando.org.exception.ErrorModel;
import com.mochiliando.org.model.dto.UserDTO;
import com.mochiliando.org.repository.UserRepository;
import com.mochiliando.org.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {

        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());

        if (optionalUserEntity.isPresent()) {
            List<ErrorModel> errorModuleList = new ArrayList<>();
            ErrorModel errorModule = new ErrorModel();
            errorModule.setErrorMessage("The password already exist");
            errorModule.setCode("EMAIL_ALREADY_EXIST");
            errorModuleList.add(errorModule);

            throw new BusinessException(errorModuleList);
        }

        UserEntity userEntity = userRepository.save(this.modelMapper.map(userDTO, UserEntity.class));


        return userConverter.convertEntityToDTO(userEntity);
    }

    @Override
    public UserDTO login(String email, String password) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);

        if (optionalUserEntity.isPresent()) {
            return userConverter.convertEntityToDTO(optionalUserEntity.get());
        }
        List<ErrorModel> errorModuleList = new ArrayList<>();
        ErrorModel errorModule = new ErrorModel();
        errorModule.setErrorMessage("Incorrect Email or Password");
        errorModule.setCode("INVALID_LOGIN");
        errorModuleList.add(errorModule);

        throw new BusinessException(errorModuleList);

    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOS = new ArrayList<>();
        userRepository.findAll().forEach((UserEntity userEntity) -> userDTOS.add(userConverter.convertEntityToDTO(userEntity)));

        return userDTOS;
    }
}