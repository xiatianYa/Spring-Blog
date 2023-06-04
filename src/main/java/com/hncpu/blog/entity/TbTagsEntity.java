package com.hncpu.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("tb_tags")
public class TbTagsEntity {
    @TableId(type = IdType.AUTO)
    /** 标签ID */
    private Integer tagsId;
    /** 标签名称 */
    private String tagsName;
    /** 标签使用数 */
    private Integer tagsRank;
    /** 标签是否删除 0 未删除 1 删除 */
    private Integer isDeleted;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createTime;
}
