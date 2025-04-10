package com.atguigu.lease.web.admin.controller.apartment;

import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.model.entity.AttrKey;
import com.atguigu.lease.model.entity.AttrValue;
import com.atguigu.lease.web.admin.service.AttrKeyService;
import com.atguigu.lease.web.admin.service.AttrValueService;
import com.atguigu.lease.web.admin.vo.attr.AttrKeyVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Attribute name (key) is the category of the attribute.
 * Attribute value is the specific item under a category.
 */
@Tag(name = "Room Attribute Management")
@RestController
@RequestMapping("/admin/attr")
public class AttrController {

    @Autowired
    private AttrKeyService attrKeyService;

    @Autowired
    private AttrValueService attrValueService;


    @Operation(summary = "Add or Update Attribute Name")
    @PostMapping("key/saveOrUpdate")
    public Result saveOrUpdateAttrKey(@RequestBody AttrKey attrKey) {
        boolean b = attrKeyService.saveOrUpdate(attrKey);
        if (b) return Result.ok();
        return Result.fail();


    }

    @Operation(summary = "Add or Update Attribute Value")
    @PostMapping("value/saveOrUpdate")
    public Result saveOrUpdateAttrValue(@RequestBody AttrValue attrValue) {
        boolean b = attrValueService.saveOrUpdate(attrValue);
        if (b) return Result.ok();
        return Result.fail();
    }

    @Operation(summary = "Get All Attribute Names and Values")
    @GetMapping("list")
    public Result<List<AttrKeyVo>> listAttrInfo() {
       List<AttrKeyVo> list =  attrKeyService.listAttrInfo();
        return Result.ok();
    }

    @Operation(summary = "Delete Attribute Name by ID")
    @DeleteMapping("key/deleteById")
    public Result removeAttrKeyById(@RequestParam Long attrKeyId) {
        return Result.ok();
    }

    @Operation(summary = "Delete Attribute Value by ID")
    @DeleteMapping("value/deleteById")
    public Result removeAttrValueById(@RequestParam Long id) {
        return Result.ok();
    }

}
