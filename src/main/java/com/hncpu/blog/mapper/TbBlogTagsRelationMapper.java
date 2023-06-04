package com.hncpu.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hncpu.blog.entity.TbBlogEntity;
import com.hncpu.blog.entity.TbBlogTagsRelationEntity;
import com.hncpu.blog.entity.TbTagsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TbBlogTagsRelationMapper extends BaseMapper<TbBlogTagsRelationEntity> {
    @Select("select tb_tags.tags_id,tb_tags.tags_name,tb_tags.tags_rank,tb_tags.is_deleted,tb_tags.create_time from tb_tags,tb_blog_tags_relation where tb_blog_tags_relation.blog_id = #{blogId}")
    List<TbTagsEntity> getTagsByBlogId(Integer blogId);
}
