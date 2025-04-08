package com.atguigu.lease.web.admin.controller.apartment;

import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.model.entity.PaymentType;
import com.atguigu.lease.web.admin.service.PaymentTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Payment Method Management")
@RequestMapping("/admin/payment")
@RestController
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    @Operation(summary = "Get all payment method list")
    @GetMapping("list")
    public Result<List<PaymentType>> listPaymentType() {

        // Filter those deleted logically (is_deleted == 1)
        QueryWrapper<PaymentType> paymentTypeQueryWrapper = new QueryWrapper<>();
        paymentTypeQueryWrapper.eq("is_deleted", 0);

        List<PaymentType> list = paymentTypeService.list(paymentTypeQueryWrapper);
        return Result.ok(list);
    }


    @Operation(summary = "Save or update payment method")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdatePaymentType(@RequestBody PaymentType paymentType) {
        // If no ID, then save, update otherwise
        paymentTypeService.saveOrUpdate(paymentType);
        return Result.ok();
    }


    @Operation(summary = "Delete payment method by ID")
    @DeleteMapping("deleteById")
    public Result deletePaymentById(@RequestParam Long id) {
        boolean deleted = paymentTypeService.removeById(id);
        if (deleted) {
            return Result.ok();
        } else {
            return Result.fail();
        }

    }

}
