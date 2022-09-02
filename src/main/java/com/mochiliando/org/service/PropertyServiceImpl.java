package com.mochiliando.org.service;

import com.mochiliando.org.converter.PropertyConverter;
import com.mochiliando.org.entity.PropertyEntity;
import com.mochiliando.org.model.dto.PropertyDTO;
import com.mochiliando.org.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
        pe = propertyRepository.save(pe);

        PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);

        return dto;
    }
}
