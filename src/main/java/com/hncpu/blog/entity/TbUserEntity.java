package com.hncpu.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("tb_user")
public class TbUserEntity {
    @TableId(type = IdType.AUTO)
    /** 用户ID */
    private Integer adminUserId;
    /** 用户账号 */
    private String loginUserName;
    /** 用户密码 */
    private String loginPassword;
    /** 用户是否被锁定 0 未锁定 1 锁定 */
    private Integer locked;
}
