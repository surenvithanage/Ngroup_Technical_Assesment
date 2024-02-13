package com.server.storeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="store")
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Indexed(unique = true)
    private String email;

    private String name;

    private String description;

    private String image;

    private String category;

    private String address;

    private String geolocation;
}
