package com.server.storeservice.dto;

import lombok.Data;

@Data
public class StoreDto {

    private String id;

    private String email;

    private String name;

    private String description;

    private String image;

    private String category;

    private String address;

    private String geolocation;
}
