package com.mochiliando.org.service;

import com.mochiliando.org.model.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {

    public PropertyDTO saveProperty(PropertyDTO propertyDTO);
    public List<PropertyDTO> getAllProperties();
    public PropertyDTO updateProperty (PropertyDTO propertyDTO, Long propertyId);
    public void deletePropertyById (Long propertyId);
}
