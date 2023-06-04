package com.hncpu.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hncpu.blog.entity.TbUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TbUserMapper extends BaseMapper<TbUserEntity> {
    @Select("select * from tb_user limit #{pageNum},#{pageSize}")
    List<TbUserEntity> selectTbBlogByPage(int pageNum, int pageSize);
}
