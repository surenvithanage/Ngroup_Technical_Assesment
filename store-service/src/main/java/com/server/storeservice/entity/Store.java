package com.server.storeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="store")
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String name;

    private String description;

    private String image;

    private String category;

    private String address;

    private String geolocation;
}
