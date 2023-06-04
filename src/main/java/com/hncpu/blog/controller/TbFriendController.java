package com.hncpu.blog.controller;

import com.hncpu.blog.common.ApiResult;
import com.hncpu.blog.entity.TbFriendEntity;
import com.hncpu.blog.entity.TbTagsEntity;
import com.hncpu.blog.service.TbFriendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/friend")
public class TbFriendController {
    @Autowired
    private TbFriendService tbFriendService;
    @GetMapping("/list")
    public ApiResult queryAll(){
        List<TbFriendEntity> tbFriendEntities = tbFriendService.queryAll();
        return ApiResult.success(tbFriendEntities);
    }
}
