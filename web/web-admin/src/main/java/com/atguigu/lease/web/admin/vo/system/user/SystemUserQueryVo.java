package com.atguigu.lease.web.admin.vo.system.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Employee Query Entity
 */
@Data
@Schema(description = "Employee Query Entity")
public class SystemUserQueryVo {

    @Schema(description = "Employee Name")
    private String name;

    @Schema(description = "Phone Number")
    private String phone;
}
