package com.hncpu.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("tb_friend")
public class TbFriendEntity {
    @TableId(type = IdType.AUTO)
    /** 友链主键 */
    private Integer friendId;
    /** 友链姓名 */
    private String friendName;
    /** 友链图片 */
    private String friendImage;
    /** 友链签名 */
    private String friendSignature;
    /** 文章是否删除 0 未删除 1 删除 */
    private Integer isDeleted;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createTime;
}
