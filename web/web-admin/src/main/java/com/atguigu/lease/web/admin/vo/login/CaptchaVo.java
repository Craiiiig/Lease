package com.atguigu.lease.web.admin.vo.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Captcha Information Value Object
 */
@Data
@Schema(description = "Image Captcha")
@AllArgsConstructor
public class CaptchaVo {

    @Schema(description = "Captcha image information")

    /**
     * Base64, convert binary image to a string.
     */
    private String image;

    @Schema(description = "Captcha key")
    private String key;
}
