package com.hncpu.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hncpu.blog.entity.TbBlogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TbBlogMapper extends BaseMapper<TbBlogEntity> {
    @Select("select * from tb_blog limit #{pageNum},#{pageSize}")
    List<TbBlogEntity> selectTbBlogByPage(int pageNum, int pageSize);
}
