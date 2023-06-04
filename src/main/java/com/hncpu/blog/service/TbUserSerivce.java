package com.hncpu.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hncpu.blog.entity.TbUserEntity;

import java.util.List;

public interface TbUserSerivce extends IService<TbUserEntity>{
    public List<TbUserEntity> queryAllByPage(int pageNum,int pageSize);
}
