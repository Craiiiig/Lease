package com.atguigu.lease.web.admin.vo.user;

import com.atguigu.lease.model.enums.BaseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * User Information Query Entity
 */
@Data
@Schema(description = "User Information Query Entity")
public class UserInfoQueryVo {

    @Schema(description = "User Phone Number")
    private String phone;

    @Schema(description = "User Account Status")
    private BaseStatus status;
}
