package com.server.storeservice.service.impl;

import com.server.storeservice.bean.keyvalue.KeyValueBean;
import com.server.storeservice.bean.response.ResponseBean;
import com.server.storeservice.dto.StoreDto;
import com.server.storeservice.entity.Store;
import com.server.storeservice.mapper.EntityMapper;
import com.server.storeservice.repository.StoreRepository;
import com.server.storeservice.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.server.storeservice.utility.varlist.CodeVarlist.STORE_INSERT;
import static com.server.storeservice.utility.varlist.CodeVarlist.STORE_LIST;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private EntityMapper entityMapper;

    @Override
    public ResponseBean list() {
        ResponseBean responseBean = new ResponseBean();

        try {
            KeyValueBean<Iterable<Store>> kvBean = new KeyValueBean<>();
            kvBean.setKey(STORE_LIST);
            kvBean.setValue(storeRepository.findAll());

            responseBean.setRequestOk(true);
            responseBean.setData(kvBean);
        } catch (Exception e) {
            throw e;
        }

        return responseBean;
    }

    @Override
    public ResponseBean insert(StoreDto dto) {
        ResponseBean responseBean = new ResponseBean();

        try {
            Store store = entityMapper.dtoToEntity(dto);
            Store created = storeRepository.save(store);

            KeyValueBean<Store> kvBean = new KeyValueBean<>();
            kvBean.setKey(STORE_INSERT);
            kvBean.setValue(created);
            responseBean.setRequestOk(true);
            responseBean.setData(kvBean);

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            throw e;
        }
        return responseBean;
    }

    @Override
    public ResponseBean update(StoreDto dto) {
        return null;
    }

    @Override
    public ResponseBean delete(String email) {
        return null;
    }
}
