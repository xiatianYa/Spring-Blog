package com.hncpu.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hncpu.blog.dto.TbBlogCountDTO;
import com.hncpu.blog.dto.TbBlogDTO;
import com.hncpu.blog.entity.TbBlogEntity;

import java.util.List;

public interface TbBlogService extends IService<TbBlogEntity> {
    List<TbBlogDTO> selectUserInfoByGtFraction(Integer pageNum, Integer pageSize);
    TbBlogCountDTO queryCount();
    public List<TbBlogEntity> queryAllByClassIfyId(Integer Id);
    public TbBlogDTO queryBlogByBlogId(Integer Id);
    public List<TbBlogEntity> queryBlogByTagsId(Integer TagsId);
}
