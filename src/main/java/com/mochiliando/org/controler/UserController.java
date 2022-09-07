package com.mochiliando.org.controler;

import com.mochiliando.org.model.dto.UserDTO;
import com.mochiliando.org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser (@RequestBody UserDTO userDTO) {
        userDTO = userService.registerUser(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser (@RequestBody UserDTO userDTO) {
        userDTO = userService.login(userDTO.getOwnerEmail(), userDTO.getPassword());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers () {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

}
