package com.hncpu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hncpu.blog.entity.TbClassifyEntity;
import com.hncpu.blog.mapper.TbClassifyMapper;
import com.hncpu.blog.service.TbClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbClassifyServiceImpl extends ServiceImpl<TbClassifyMapper, TbClassifyEntity> implements TbClassifyService {
    @Autowired
    private TbClassifyMapper tbClassifyMapper;
    /** 查询全部归档 */
    @Override
    public List<TbClassifyEntity> queryAll() {
        LambdaQueryWrapper lambdaQueryWrapper=new LambdaQueryWrapper();
        List<TbClassifyEntity> list = tbClassifyMapper.selectList(lambdaQueryWrapper);
        return list;
    }
    /** 通过归档数量 */
    @Override
    public Integer queryCount() {
        Integer integer = tbClassifyMapper.selectCount(new LambdaQueryWrapper<>());
        return integer;
    }

}
