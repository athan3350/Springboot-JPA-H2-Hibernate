package com.mochiliando.org.converter;

import com.mochiliando.org.entity.PropertyEntity;
import com.mochiliando.org.model.dto.PropertyDTO;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity (PropertyDTO propertyDTO) {

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle(propertyDTO.getTitle());
        propertyEntity.setDescription(propertyDTO.getDescription());
        propertyEntity.setAddress(propertyDTO.getAddress());
        propertyEntity.setPrice(propertyDTO.getPrice());
        propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
        propertyEntity.setUserName(propertyDTO.getUserName());

        return propertyEntity;

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
