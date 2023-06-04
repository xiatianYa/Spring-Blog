package com.hncpu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hncpu.blog.entity.TbFriendEntity;
import com.hncpu.blog.mapper.TbFriendMapper;
import com.hncpu.blog.service.TbFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbFriendServiceImpl extends ServiceImpl<TbFriendMapper, TbFriendEntity> implements TbFriendService {
    @Autowired
    private TbFriendMapper tbFriendMapper;
    /** 查询友链列表 */
    @Override
    public List<TbFriendEntity> queryAll() {
        List<TbFriendEntity> tbFriendEntities = tbFriendMapper.selectList(new LambdaQueryWrapper<>());
        return tbFriendEntities;
    }
}
