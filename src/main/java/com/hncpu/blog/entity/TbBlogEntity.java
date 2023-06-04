package com.hncpu.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("tb_blog")
public class TbBlogEntity {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    /** 文章ID */
    private Integer blogId;
    /** 文章标题 */
    private String blogTitle;
    /** 文章内容 */
    private String blogContent;
    /** 文章归档ID */
    private Integer blogClassifyId;
    /** 文章状态 0 完成 1 编辑 */
    private Integer blogStatus;
    /** 文章是否删除 0 未删除 1 删除 */
    private Integer isDeleted;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;
}
