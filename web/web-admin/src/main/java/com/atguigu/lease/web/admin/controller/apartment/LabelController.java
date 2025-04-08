package com.atguigu.lease.web.admin.controller.apartment;

import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.model.entity.LabelInfo;
import com.atguigu.lease.model.enums.ItemType;
import com.atguigu.lease.web.admin.service.LabelInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Label Management")
@RestController
@RequestMapping("/admin/label")
public class LabelController {

    @Autowired
    private LabelInfoService labelInfoService;

    @Operation(summary = "Query label list (by type)")
    @GetMapping("list")
    public Result<List<LabelInfo>> labelList(@RequestParam(required = false) ItemType type) {
        // Attention ! If int 1/0 was transferred, must convert to Enum
        // Use CONVERTER

        System.err.println("type = " + type);
        // Filter conditions
        QueryWrapper<LabelInfo> labelInfoQueryWrapper = new QueryWrapper<>();
        labelInfoQueryWrapper.eq(type != null, "type", type);

        List<LabelInfo> list = labelInfoService.list(labelInfoQueryWrapper);
        return Result.ok(list);
    }

    @Operation(summary = "Add or modify label information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdateLabel(@RequestBody LabelInfo labelInfo) {
        return Result.ok();
    }

    @Operation(summary = "Delete label information by ID")
    @DeleteMapping("deleteById")
    public Result deleteLabelById(@RequestParam Long id) {
        return Result.ok();
    }
}
