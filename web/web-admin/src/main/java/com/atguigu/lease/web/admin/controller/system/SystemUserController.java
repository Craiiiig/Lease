package com.atguigu.lease.web.admin.controller.system;

import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.model.entity.SystemUser;
import com.atguigu.lease.model.enums.BaseStatus;
import com.atguigu.lease.web.admin.service.SystemUserService;
import com.atguigu.lease.web.admin.vo.system.user.SystemUserItemVo;
import com.atguigu.lease.web.admin.vo.system.user.SystemUserQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Admin User Information Management")
@RestController
@RequestMapping("/admin/system/user")
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;

    @Operation(summary = "Paginated query of admin user list based on conditions")
    @GetMapping("page")
    public Result<IPage<SystemUser>> page(@RequestParam long current, @RequestParam long size, SystemUserQueryVo queryVo) {
        Page<SystemUser> page = new Page<>(current, size);
        IPage<SystemUser> result = systemUserService.pageSystemUser(page, queryVo);

        return Result.ok(result);
    }

    @Operation(summary = "Get admin user information by ID")
    @GetMapping("getById")
    public Result<SystemUserItemVo> getById(@RequestParam Long id) {
        SystemUserItemVo result = systemUserService.getSystemUserById(id);
        return Result.ok(result);
    }

    @Operation(summary = "Save or update admin user information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SystemUser systemUser) {
        // Encrypt the user's original password using the MD5 algorithm and set it as the user's password.
        if (systemUser.getPassword() != null) systemUser.setPassword(DigestUtils.md5Hex(systemUser.getPassword()));
        systemUserService.saveOrUpdate(systemUser);
        return Result.ok();
    }

    @Operation(summary = "Check if admin username is available")
    @GetMapping("isUserNameAvailable")
    public Result<Boolean> isUsernameExists(@RequestParam String username) {
        QueryWrapper<SystemUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        long count = systemUserService.count(wrapper);
        return Result.ok(count == 0); // 0 = username is available
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "Delete admin user information by ID")
    public Result removeById(@RequestParam Long id) {
        systemUserService.removeById(id);
        return Result.ok();
    }

    @Operation(summary = "Update admin user status by ID")
    @PostMapping("updateStatusByUserId")
    public Result updateStatusByUserId(@RequestParam Long id, @RequestParam BaseStatus status) {
        UpdateWrapper<SystemUser> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", id);
        wrapper.eq("status", status);
        systemUserService.update(wrapper);
        return Result.ok();
    }
}
