package com.mochiliando.org.service.impl;

import com.mochiliando.org.entity.PropertyEntity;
import com.mochiliando.org.model.dto.PropertyDTO;
import com.mochiliando.org.repository.PropertyRepository;
import com.mochiliando.org.service.PropertyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = propertyRepository.save(this.modelMapper.map(propertyDTO, PropertyEntity.class));
        return modelMapper.map(propertyEntity, PropertyDTO.class);
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyDTO> propertyDTOS = new ArrayList<>();
        propertyRepository.findAll()
                .forEach((PropertyEntity pr) ->
                        propertyDTOS.add(this.modelMapper.map(pr, PropertyDTO.class)));

        return propertyDTOS;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);
        PropertyEntity propertyEntity = null;
        if (optionalPropertyEntity.isPresent()) {
            propertyEntity =  propertyRepository.save(this.modelMapper.map(propertyDTO, PropertyEntity.class));
        }
        return modelMapper.map(propertyEntity, PropertyDTO.class);
    }

    @Override
    public void deletePropertyById(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
