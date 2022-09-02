package com.mochiliando.org.controler;

import com.mochiliando.org.model.dto.PropertyDTO;
import com.mochiliando.org.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;
    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @PostMapping("/save")
    public ResponseEntity<PropertyDTO> saveProperty (@RequestBody PropertyDTO propertyDTO) {
        propertyDTO = propertyService.saveProperty(propertyDTO);
        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    }
}
