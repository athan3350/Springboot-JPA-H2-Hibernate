package com.mochiliando.org.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyDTO {

    private Long id;
    private String title;
    private String description;
    private String userName;
    private String ownerEmail;
    private String price;
    private String address;
}
