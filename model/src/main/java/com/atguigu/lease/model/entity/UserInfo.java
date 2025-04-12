package com.atguigu.lease.model.entity;

import com.atguigu.lease.model.enums.BaseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "User Information Table")
@TableName(value = "user_info")
@Data
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Phone Number (used as login username)")
    @TableField(value = "phone")
    private String phone;

    @Schema(description = "Password")
    @TableField(value = "password")
    private String password;

    @Schema(description = "Avatar URL")
    @TableField(value = "avatar_url")
    private String avatarUrl;

    @Schema(description = "Nickname")
    @TableField(value = "nickname")
    private String nickname;

    @Schema(description = "Account Status")
    @TableField(value = "status")
    private BaseStatus status;

}
