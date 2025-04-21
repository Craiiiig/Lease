package com.atguigu.lease.web.admin.controller.login;

import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.web.admin.service.LoginService;
import com.atguigu.lease.web.admin.vo.login.CaptchaVo;
import com.atguigu.lease.web.admin.vo.login.LoginVo;
import com.atguigu.lease.web.admin.vo.system.user.SystemUserInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Admin System Login Management")
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Operation(summary = "Get image captcha")
    @GetMapping("login/captcha")
    public Result<CaptchaVo> getCaptcha() {
        CaptchaVo result = loginService.getCaptcha();
        return Result.ok(result);
    }

    @Operation(summary = "Login")
    @PostMapping("login")
    public Result<String> login(@RequestBody LoginVo loginVo) {
        String jwt = loginService.login(loginVo);
        return Result.ok(jwt);
    }

    @Operation(summary = "Get logged-in user profile information")
    @GetMapping("info")
    public Result<SystemUserInfoVo> info() {
        return Result.ok();
    }
}
