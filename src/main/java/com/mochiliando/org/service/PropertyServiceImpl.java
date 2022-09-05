package com.mochiliando.org.service;

import com.mochiliando.org.converter.PropertyConverter;
import com.mochiliando.org.entity.PropertyEntity;
import com.mochiliando.org.model.dto.PropertyDTO;
import com.mochiliando.org.repository.PropertyRepository;
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
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
        pe = propertyRepository.save(pe);
        return propertyConverter.convertEntityToDTO(pe);
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyDTO> propertyDTOS = new ArrayList<>();

        propertyRepository.findAll()
                .forEach((PropertyEntity pr) ->
                        propertyDTOS.add(propertyConverter.convertEntityToDTO(pr)));

        return propertyDTOS;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;

        if (optionalPropertyEntity.isPresent()) {
            PropertyEntity pe = optionalPropertyEntity.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setDescription(propertyDTO.getDescription());
            pe.setAddress(propertyDTO.getAddress());
            pe.setPrice(propertyDTO.getPrice());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setUserName(propertyDTO.getUserName());

            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deletePropertyById(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
