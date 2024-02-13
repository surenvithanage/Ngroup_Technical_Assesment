package com.server.storeservice.controller;

import com.server.storeservice.bean.response.ResponseBean;
import com.server.storeservice.dto.StoreDto;
import com.server.storeservice.service.StoreService;
import com.server.storeservice.utility.function.Common;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/store")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StoreController {

    private final Common common;

    private final StoreService service;

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseBean> list() {
        ResponseBean responseBean = service.list();
        return common.getResponseEntityBean(responseBean);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<ResponseBean> insert(@Valid @RequestBody StoreDto requestDto) {
        ResponseBean responseBean = service.insert(requestDto);
        return common.getResponseEntityBean(responseBean);
    }
}
