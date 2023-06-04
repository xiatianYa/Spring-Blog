package com.hncpu.blog.controller;

import com.hncpu.blog.common.ApiResult;
import com.hncpu.blog.entity.TbClassifyEntity;
import com.hncpu.blog.service.TbClassifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/classify")
public class TbClassifyController {
    @Autowired
    private TbClassifyService tbClassifyService;
    @GetMapping("/list")
    public ApiResult queryAll(){
        List<TbClassifyEntity> tbClassifyEntities = tbClassifyService.queryAll();
        return ApiResult.success(tbClassifyEntities);
    }
}
