package com.atguigu.lease.web.admin.controller.apartment;

import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.model.entity.FacilityInfo;
import com.atguigu.lease.model.enums.ItemType;
import com.atguigu.lease.web.admin.service.FacilityInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Facility Management")
@RestController
@RequestMapping("/admin/facility")
public class FacilityController {

    @Autowired
    private FacilityInfoService facilityInfoService;

    @Operation(summary = "[By Type] Get Facility Info List")
    @GetMapping("list")
    public Result<List<FacilityInfo>> listFacility(@RequestParam(required = false) ItemType type) {
        List<FacilityInfo> list;
        QueryWrapper<FacilityInfo> queryWrapper = new QueryWrapper<>();
        if (type != null) {
            queryWrapper.eq("type", type);
            list = facilityInfoService.list(queryWrapper);
        } else {
            list = facilityInfoService.list();
        }
        return Result.ok(list);
    }

    @Operation(summary = "Add or Update Facility Info")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody FacilityInfo facilityInfo) {
        boolean b = facilityInfoService.saveOrUpdate(facilityInfo);
        if (b) return Result.ok();
        return Result.fail();

    }

    @Operation(summary = "Delete Facility Info by ID")
    @DeleteMapping("deleteById")
    public Result removeFacilityById(@RequestParam Long id) {
        boolean b = facilityInfoService.removeById(id);
        if (b) return Result.ok();
        return Result.fail();

    }

}
