package com.hncpu.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hncpu.blog.entity.TbBlogEntity;
import com.hncpu.blog.entity.TbUserEntity;
import com.hncpu.blog.mapper.TbUserMapper;
import com.hncpu.blog.service.TbUserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUserEntity> implements TbUserSerivce {
    @Autowired
    private TbUserMapper tbUserMapper;
    /** 查询所有用户 */
    @Override
    public List<TbUserEntity> queryAllByPage(int pageNum, int pageSize) {
        List<TbUserEntity> tbUserEntities = tbUserMapper.selectTbBlogByPage(pageNum, pageSize);
        return tbUserEntities;
    }
}
