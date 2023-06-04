package com.hncpu.blog.controller;

import com.hncpu.blog.common.ApiResult;
import com.hncpu.blog.entity.TbUserEntity;
import com.hncpu.blog.service.TbUserSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class TbUserController {
    @Autowired
    private TbUserSerivce tbUserSerivce;
    @GetMapping("/list")
    public ApiResult queryAllByPage(@RequestParam(value = "pageNum",defaultValue = "0") int pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        List<TbUserEntity> tbUserEntities = tbUserSerivce.queryAllByPage(pageNum, pageSize);
        return ApiResult.success(tbUserEntities);
    }
}
