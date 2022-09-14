package com.mochiliando.org.controler;

import com.mochiliando.org.model.dto.PropertyDTO;
import com.mochiliando.org.service.PropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Property APIs")
@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;
    @ApiOperation(value = "Save property", notes = "This method is used to save a property")
    @PostMapping(path = "", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<PropertyDTO> saveProperty (@RequestBody PropertyDTO propertyDTO) {
        propertyDTO = propertyService.saveProperty(propertyDTO);
        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get all properties", notes = "This method is used to get all properties")
    @GetMapping(path = "", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<List<PropertyDTO>> getAllProperties () {
        return new ResponseEntity<>(propertyService.getAllProperties(), HttpStatus.OK);
    }

    @ApiOperation(value = "Update property", notes = "This method is used to update an specific property")
    @PutMapping(path = "/{propertyId}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId ) {
        return new ResponseEntity<>(propertyService.updateProperty(propertyDTO, propertyId), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete property", notes = "This method is used to delete an specific property")
    @DeleteMapping(path = "/{propertyId}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Void> deletePropertyById ( @PathVariable Long propertyId ) {
        propertyService.deletePropertyById(propertyId);
        return ResponseEntity.noContent().build();
    }

}
