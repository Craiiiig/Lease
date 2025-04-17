package com.atguigu.lease.web.admin.controller.user;

import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.model.entity.UserInfo;
import com.atguigu.lease.model.enums.BaseStatus;
import com.atguigu.lease.web.admin.service.UserInfoService;
import com.atguigu.lease.web.admin.vo.user.UserInfoQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This is the class for Rental App Users, not the management system user.
 */
@Tag(name = "User Information Management")
@RestController
@RequestMapping("/admin/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @Operation(summary = "Paginated query of user information")
    @GetMapping("page")
    public Result<IPage<UserInfo>> pageUserInfo(@RequestParam long current, @RequestParam long size, UserInfoQueryVo queryVo) {
        Page<UserInfo> page = new Page<>(current, size);
        QueryWrapper<UserInfo> qw = new QueryWrapper<>();
        if (queryVo.getPhone() != null) qw.like("phone", queryVo.getPhone());
        if (queryVo.getStatus() != null) qw.eq("status", queryVo.getStatus());
        IPage<UserInfo> result = userInfoService.page(page, qw);
        return Result.ok(result);
    }

    /**
     * Update user status by ID
     *
     * @param id     user id
     * @param status Enable/Disable
     * @return successful / unsuccessful code
     */
    @Operation(summary = "Update account status by user ID")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam BaseStatus status) {
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        updateWrapper.set("status", status);
        userInfoService.update(updateWrapper);
        return Result.ok();
    }
}
