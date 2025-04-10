package com.atguigu.lease.web.admin.vo.system.user;

import com.atguigu.lease.model.entity.SystemUser;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Backend Management System User Basic Information Entity
 */
@Data
@Schema(description = "Backend Management System User Basic Information Entity")
public class SystemUserItemVo extends SystemUser {

    @Schema(description = "Job Title")
    @TableField(value = "post_name")
    private String postName;

}
