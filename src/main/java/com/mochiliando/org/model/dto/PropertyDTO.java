package com.mochiliando.org.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PropertyDTO {

    private Long id;
    private String title;
    private String description;
    private String userName;
    private String ownerEmail;
    private String price;
    private String address;
}
