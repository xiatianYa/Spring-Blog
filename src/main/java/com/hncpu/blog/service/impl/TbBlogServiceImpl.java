package com.hncpu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hncpu.blog.dto.TbBlogCountDTO;
import com.hncpu.blog.dto.TbBlogDTO;
import com.hncpu.blog.entity.TbBlogEntity;
import com.hncpu.blog.entity.TbBlogTagsRelationEntity;
import com.hncpu.blog.entity.TbTagsEntity;
import com.hncpu.blog.mapper.TbBlogMapper;
import com.hncpu.blog.service.TbBlogService;
import com.hncpu.blog.service.TbBlogTagsRelationService;
import com.hncpu.blog.service.TbClassifyService;
import com.hncpu.blog.service.TbTagsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TbBlogServiceImpl extends ServiceImpl<TbBlogMapper, TbBlogEntity> implements TbBlogService  {
    @Autowired
    private TbBlogMapper tbBlogMapper;
    @Autowired
    private TbBlogTagsRelationService tbBlogTagsRelationService;
    @Autowired
    private TbTagsService tbTagsService;
    @Autowired
    private TbClassifyService tbClassifyService;
    /** 分页查询文章列表 并查询标签列表 */
    @Override
    public List<TbBlogDTO> selectUserInfoByGtFraction(Integer pageNum, Integer pageSize) {
        List<TbBlogEntity> tbBlogEntities = tbBlogMapper.selectTbBlogByPage(pageNum, pageSize);
        List<TbBlogDTO> stream = tbBlogEntities.stream().map((item) -> {
            if (item.getBlogStatus() == 1) {
                return null;
            }
            TbBlogDTO tbBlogDTO = new TbBlogDTO();
            BeanUtils.copyProperties(item,tbBlogDTO);
            tbBlogDTO.setCount(tbBlogEntities.size());
            List<TbTagsEntity> tagsByBlogId = tbBlogTagsRelationService.getTagsByBlogId(item.getBlogId());
            tbBlogDTO.setTbTagsEntityList(tagsByBlogId);
            return tbBlogDTO;
        }).collect(Collectors.toList());
        return stream;
    }
    /** 查询文章数量 */
    @Override
    public TbBlogCountDTO queryCount() {
        Integer blogCount = tbBlogMapper.selectCount(new LambdaQueryWrapper<>());
        Integer classifyCount = tbClassifyService.queryCount();
        Integer tagsCount = tbTagsService.queryCount();
        return new TbBlogCountDTO(blogCount,classifyCount,tagsCount);
    }
    /** 通过ClassIfyId 来查询文章列表 */
    @Override
    public List<TbBlogEntity> queryAllByClassIfyId(Integer Id) {
        LambdaQueryWrapper<TbBlogEntity> BlogLQ=new LambdaQueryWrapper<>();
        BlogLQ.eq(TbBlogEntity::getBlogClassifyId,Id);
        List<TbBlogEntity> tbBlogEntities = tbBlogMapper.selectList(BlogLQ);
        return tbBlogEntities;
    }
    /** 通过文章ID 查询文章 */
    @Override
    public TbBlogDTO queryBlogByBlogId(Integer Id) {
        TbBlogDTO tbBlogDTO=new TbBlogDTO();
        LambdaQueryWrapper<TbBlogEntity> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(TbBlogEntity::getBlogId,Id);
        TbBlogEntity tbBlogEntity = tbBlogMapper.selectOne(lambdaQueryWrapper);
        List<TbTagsEntity> tagsByBlogId = tbBlogTagsRelationService.getTagsByBlogId(tbBlogEntity.getBlogId());
        BeanUtils.copyProperties(tbBlogEntity,tbBlogDTO);
        tbBlogDTO.setTbTagsEntityList(tagsByBlogId);
        return tbBlogDTO;
    }
    @Override
    /** 通过TagsId 和文章Id 查询文章列表 */
    public List<TbBlogEntity> queryBlogByTagsId(Integer TagsId){
        LambdaQueryWrapper<TbBlogTagsRelationEntity> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .eq(TbBlogTagsRelationEntity::getTagsId,TagsId);
        List<TbBlogTagsRelationEntity> list = tbBlogTagsRelationService.list(lambdaQueryWrapper);
        List<TbBlogEntity> collect = list.stream().map((item) -> {
            LambdaQueryWrapper<TbBlogEntity> lambdaQueryWrapper1 = new LambdaQueryWrapper<>();
            lambdaQueryWrapper1.eq(TbBlogEntity::getBlogId, item.getBlogId());
            TbBlogEntity tbBlogEntity = tbBlogMapper.selectOne(lambdaQueryWrapper1);
            return tbBlogEntity;
        }).collect(Collectors.toList());
        return collect;
    }
}
