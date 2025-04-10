package com.atguigu.lease.web.admin.vo.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Login Information for the Admin Management System
 */
@Data
@Schema(description = "Admin Management System Login Information")
public class LoginVo {

    @Schema(description="Username")
    private String username;

    @Schema(description="Password")
    private String password;

    @Schema(description="Captcha key")
    private String captchaKey;

    @Schema(description="Captcha code")
    private String captchaCode;
}
