package com.hncpu.blog.controller;

import com.hncpu.blog.common.ApiResult;
import com.hncpu.blog.dto.TbBlogCountDTO;
import com.hncpu.blog.dto.TbBlogDTO;
import com.hncpu.blog.entity.TbBlogEntity;
import com.hncpu.blog.service.TbBlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/blog")
public class TbBlogController {
    @Autowired
    private TbBlogService tbBlogService;
    @GetMapping("/list/{pageNum}/{pageSize}")
    public ApiResult queryAllByPage(@PathVariable(value = "pageNum") int pageNum,
                                    @PathVariable(value = "pageSize") int pageSize){
        List<TbBlogDTO> tbBlogDTOS = tbBlogService.selectUserInfoByGtFraction(pageNum, pageSize);
        return ApiResult.success(tbBlogDTOS);
    }
    @GetMapping("/count")
    public ApiResult queryCount(){
        TbBlogCountDTO tbBlogCountDTO = tbBlogService.queryCount();
        return ApiResult.success(tbBlogCountDTO);
    }
    @GetMapping("/byClass/{Id}")
    public ApiResult queryAllByClassIfyId(@PathVariable Integer Id){
        List<TbBlogEntity> tbBlogEntities = tbBlogService.queryAllByClassIfyId(Id);
        return ApiResult.success(tbBlogEntities);
    }
    @GetMapping("/list/{Id}")
    public ApiResult queryBlogByBlogId(@PathVariable Integer Id){
        TbBlogDTO tbBlogDTO = tbBlogService.queryBlogByBlogId(Id);
        return ApiResult.success(tbBlogDTO);
    }
    @GetMapping("/byTags/{Id}")
    public ApiResult queryBlogByTagsId(@PathVariable Integer Id){
        List<TbBlogEntity> tbBlogEntities = tbBlogService.queryBlogByTagsId(Id);
        return ApiResult.success(tbBlogEntities);
    }
}
