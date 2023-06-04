package com.hncpu.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("tb_classify")
public class TbClassifyEntity {
    @TableId(type = IdType.AUTO)
    /** 归档ID */
    private Integer classifyId;
    /** 文章名称 */
    private String classifyName;
    /** 标签是否删除 0 未删除 1 删除 */
    private Integer isDeleted;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createTime;
}
