package com.hncpu.blog.dto;

import com.hncpu.blog.entity.TbBlogEntity;
import com.hncpu.blog.entity.TbTagsEntity;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class TbBlogDTO extends TbBlogEntity {
    private static final long serialVersionUID = 1L;
    private Integer blogId;
    /** 文章标题 */
    private String blogTitle;
    /** 文章内容 */
    private String blogContent;
    /** 文章归档id */
    private Integer blogClassifyId;
    /** 文章状态id 0完成 1编辑 */
    private Integer blogStatus;
    /** 文章数量 */
    private Integer count;
    private List<TbTagsEntity> tbTagsEntityList;
    private Timestamp createTime;
    private Timestamp updateTime;

}
