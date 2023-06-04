package com.hncpu.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hncpu.blog.entity.TbTagsEntity;

import java.util.List;

public interface TbTagsService extends IService<TbTagsEntity> {
    public List<TbTagsEntity> queryAll();
    public Integer queryCount();
}
