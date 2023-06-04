package com.hncpu.blog.controller;

import com.hncpu.blog.common.ApiResult;
import com.hncpu.blog.entity.TbTagsEntity;
import com.hncpu.blog.service.TbTagsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/tags")
public class TbTagsController {
    @Autowired
    private TbTagsService tagsService;
    @GetMapping("/list")
    public ApiResult queryAll(){
        List<TbTagsEntity> tbTagsEntities = tagsService.queryAll();
        return ApiResult.success(tbTagsEntities);
    }
}
