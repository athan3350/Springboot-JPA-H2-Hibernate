package com.mochiliando.org.converter;

import com.mochiliando.org.entity.PropertyEntity;
import com.mochiliando.org.model.dto.PropertyDTO;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity (PropertyDTO propertyDTO) {

        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setAddress(propertyDTO.getAddress());
        pe.setPrice(propertyDTO.getPrice());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setUserName(propertyDTO.getUserName());

        return pe;

    }

    public PropertyDTO convertEntityToDTO (PropertyEntity propertyEntity) {

        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDTO.setUserName(propertyEntity.getUserName());

        return propertyDTO;

    }
}
