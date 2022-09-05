package com.mochiliando.org.controler;

import com.mochiliando.org.model.dto.PropertyDTO;
import com.mochiliando.org.service.PropertyService;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @PostMapping("")
    public ResponseEntity<PropertyDTO> saveProperty (@RequestBody PropertyDTO propertyDTO) {
        propertyDTO = propertyService.saveProperty(propertyDTO);
        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<PropertyDTO>> getAllProperties () {
        return new ResponseEntity<>(propertyService.getAllProperties(), HttpStatus.OK);
    }

    @PutMapping("/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId ) {
        return new ResponseEntity<>(propertyService.updateProperty(propertyDTO, propertyId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{propertyId}")
    public ResponseEntity<Void> deletePropertyById ( @PathVariable Long propertyId ) {
        propertyService.deletePropertyById(propertyId);
        return ResponseEntity.noContent().build();
    }


}
