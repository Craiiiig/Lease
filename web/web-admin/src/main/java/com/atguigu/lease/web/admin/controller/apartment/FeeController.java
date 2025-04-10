package com.atguigu.lease.web.admin.controller.apartment;

import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.model.entity.FeeKey;
import com.atguigu.lease.model.entity.FeeValue;
import com.atguigu.lease.web.admin.service.FeeKeyService;
import com.atguigu.lease.web.admin.service.FeeValueService;
import com.atguigu.lease.web.admin.vo.fee.FeeKeyVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Room Miscellaneous Fee Management")
@RestController
@RequestMapping("/admin/fee")
public class FeeController {

    @Autowired
    private FeeKeyService feeKeyService;
    @Autowired
    private FeeValueService feeValueService;

    @Operation(summary = "Save or update fee name")
    @PostMapping("key/saveOrUpdate")
    public Result saveOrUpdateFeeKey(@RequestBody FeeKey feeKey) {
        feeKeyService.save(feeKey);
        return Result.ok();
    }

    @Operation(summary = "Save or update fee value")
    @PostMapping("value/saveOrUpdate")
    public Result saveOrUpdateFeeValue(@RequestBody FeeValue feeValue) {
        feeValueService.saveOrUpdate(feeValue);
        return Result.ok();
    }

    @Operation(summary = "Get list of all fee names and values")
    @GetMapping("list")
    public Result<List<FeeKeyVo>> feeInfoList() {
        List<FeeKeyVo> list = feeKeyService.feeInfoList();
        return Result.ok(list);
    }

    @Operation(summary = "Delete fee name by ID")
    @DeleteMapping("key/deleteById")
    public Result deleteFeeKeyById(@RequestParam Long feeKeyId) {

        boolean b = feeKeyService.removeById(feeKeyId);
        if (b) return Result.ok();
        return Result.fail();
    }

    @Operation(summary = "Delete fee value by ID")
    @DeleteMapping("value/deleteById")
    public Result deleteFeeValueById(@RequestParam Long id) {
        QueryWrapper<FeeValue> feeValueQueryWrapper = new QueryWrapper<>();
        feeValueQueryWrapper.eq("fee_key_id", id);
        feeValueService.remove(feeValueQueryWrapper);
        return Result.ok();
    }
}
