package com.atguigu.lease.web.admin.vo.system.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Employee Basic Information
 */
@Schema(description = "Employee Basic Information")
@Data
public class SystemUserInfoVo {

    @Schema(description = "User's Name")
    private String name;

    @Schema(description = "User's Avatar URL")
    private String avatarUrl;

}
