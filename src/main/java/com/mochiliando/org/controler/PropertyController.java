package com.mochiliando.org.controler;

import com.mochiliando.org.model.dto.PropertyDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @PostMapping("/save")
    public PropertyDTO saveProperty (@RequestBody PropertyDTO propertyDTO) {
        return propertyDTO;
    }
}
