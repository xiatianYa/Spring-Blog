package com.hncpu.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hncpu.blog.entity.TbClassifyEntity;

import java.util.List;

public interface TbClassifyService extends IService<TbClassifyEntity> {
    public List<TbClassifyEntity> queryAll();
    public Integer queryCount();
}
