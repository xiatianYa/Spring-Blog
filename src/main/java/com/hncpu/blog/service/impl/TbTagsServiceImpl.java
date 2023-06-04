package com.hncpu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hncpu.blog.entity.TbTagsEntity;
import com.hncpu.blog.mapper.TbTagsMapper;
import com.hncpu.blog.service.TbTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbTagsServiceImpl extends ServiceImpl<TbTagsMapper, TbTagsEntity> implements TbTagsService {
    @Autowired
    private TbTagsMapper tbTagsMapper;
    /** 查询所有标签 */
    @Override
    public List<TbTagsEntity> queryAll() {
        List<TbTagsEntity> tbTagsEntities = tbTagsMapper.selectList(new LambdaQueryWrapper<>());
        return tbTagsEntities;
    }
    /** 查询标签数量 */
    @Override
    public Integer queryCount() {
        return tbTagsMapper.selectCount(new LambdaQueryWrapper<>());
    }

}
