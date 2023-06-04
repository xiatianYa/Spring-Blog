package com.hncpu.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hncpu.blog.entity.TbFriendEntity;

import java.util.List;

public interface TbFriendService extends IService<TbFriendEntity> {
    public List<TbFriendEntity> queryAll();
}
