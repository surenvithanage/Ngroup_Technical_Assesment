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

import java.util.Optional;

import static com.server.storeservice.utility.varlist.CodeVarlist.*;
import static com.server.storeservice.utility.varlist.MessageVarList.DUPLICATE_EMAIL_RECORD;
import static com.server.storeservice.utility.varlist.MessageVarList.RECORD_NOT_FOUND;

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
            responseBean.setMessageType(SUCCESS);

            responseBean.setData(kvBean);
        } catch (Exception e) {
            throw e;
        }

        return responseBean;
    }

    @Override
    public ResponseBean find(String id) {
        ResponseBean responseBean = new ResponseBean();
        KeyValueBean<Store> kvBean = new KeyValueBean<>();

        try {
            Optional<Store> optional = storeRepository.findById(id);
            if (optional.isPresent()) {
                Store store = optional.get();
                kvBean.setKey(STORE_OBJECT);
                kvBean.setValue(store);

                responseBean.setRequestOk(true);
                responseBean.setMessageType(SUCCESS);

                responseBean.setData(kvBean);
            } else {
                responseBean.setRequestOk(false);
                responseBean.setMessageType(ERROR);
                responseBean.setMessage(RECORD_NOT_FOUND);
            }
        } catch (Exception e) {
            throw e;
        }

        return responseBean;
    }

    @Override
    public ResponseBean insert(StoreDto dto) {
        ResponseBean responseBean = new ResponseBean();

        try {
            Optional<Store> exists = storeRepository.findByEmail(dto.getEmail());

            if (exists.isEmpty()) {
                Store store = entityMapper.dtoToEntity(dto);

                Store created = storeRepository.save(store);

                KeyValueBean<Store> kvBean = new KeyValueBean<>();
                kvBean.setKey(STORE_INSERT);
                kvBean.setValue(created);
                responseBean.setRequestOk(true);
                responseBean.setMessageType(SUCCESS);

                responseBean.setData(kvBean);
            } else {
                responseBean.setRequestOk(false);
                responseBean.setMessageType(ERROR);
                responseBean.setMessage(DUPLICATE_EMAIL_RECORD);
            }

        } catch (Exception e) {
            throw e;
        }
        return responseBean;
    }

    @Override
    public ResponseBean update(StoreDto dto) {
        ResponseBean responseBean = new ResponseBean();
        KeyValueBean<Store> kvBean = new KeyValueBean<>();

        try {
            Optional<Store> optional = storeRepository.findById(dto.getId());
            if (optional.isPresent()) {
                Store store = optional.get();

                store.setName(dto.getName());
                store.setGeolocation(dto.getGeolocation());
                store.setDescription(dto.getDescription());
                store.setAddress(dto.getAddress());
                store.setImage(dto.getImage());
                store.setCategory(dto.getCategory());

                Store updated = storeRepository.save(store);

                kvBean.setKey(STORE_UPDATE);
                kvBean.setValue(updated);

                responseBean.setRequestOk(true);
                responseBean.setMessageType(SUCCESS);

                responseBean.setData(kvBean);
            } else {
                responseBean.setRequestOk(false);
                responseBean.setMessageType(ERROR);
                responseBean.setMessage(RECORD_NOT_FOUND);
            }
        } catch (Exception e) {
            throw e;
        }

        return responseBean;
    }

    @Override
    public ResponseBean delete(String id) {
        ResponseBean responseBean = new ResponseBean();
        KeyValueBean<Store> kvBean = new KeyValueBean<>();

        try {
            Optional<Store> optional = storeRepository.findById(id);
            if (optional.isPresent()) {
                Store store = optional.get();
                storeRepository.delete(store);

                kvBean.setKey(STORE_DELETE);
                kvBean.setValue(store);

                responseBean.setRequestOk(true);
                responseBean.setMessageType(SUCCESS);

                responseBean.setData(kvBean);
            } else {
                responseBean.setRequestOk(false);
                responseBean.setMessageType(ERROR);
                responseBean.setMessage(RECORD_NOT_FOUND);
            }
        } catch (Exception e) {
            throw e;
        }

        return responseBean;
    }
}
