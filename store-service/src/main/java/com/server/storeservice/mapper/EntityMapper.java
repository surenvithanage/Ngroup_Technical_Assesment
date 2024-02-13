package com.server.storeservice.mapper;

import com.server.storeservice.dto.StoreDto;
import com.server.storeservice.entity.Store;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

    public Store dtoToEntity(StoreDto dto) {
        Store store = new Store();
        store.setName(dto.getName());
        store.setCategory(dto.getCategory());
        store.setEmail(dto.getEmail());
        store.setDescription(dto.getDescription());
        store.setGeolocation(dto.getGeolocation());
        store.setAddress(dto.getAddress());
        store.setImage(dto.getImage());
        return store;
    }
}
