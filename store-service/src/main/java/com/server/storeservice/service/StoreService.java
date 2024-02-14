package com.server.storeservice.service;

import com.server.storeservice.bean.response.ResponseBean;
import com.server.storeservice.dto.StoreDto;

public interface StoreService {

    ResponseBean list();
    ResponseBean find(String id);
    ResponseBean insert(StoreDto dto);
    ResponseBean update(StoreDto dto);
    ResponseBean delete(String id);
}
