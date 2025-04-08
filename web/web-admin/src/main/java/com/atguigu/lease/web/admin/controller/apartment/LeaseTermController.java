package com.atguigu.lease.web.admin.controller.apartment;

import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.model.entity.LeaseTerm;
import com.atguigu.lease.web.admin.service.LeaseTermService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Lease Term Management")
@RequestMapping("/admin/term")
@RestController
public class LeaseTermController {

    @Autowired
    private LeaseTermService leaseTermService;

    @GetMapping("list")
    @Operation(summary = "Query all lease term list")
    public Result<List<LeaseTerm>> listLeaseTerm() {
        List<LeaseTerm> list = leaseTermService.list();
        return Result.ok(list);
    }

    @PostMapping("saveOrUpdate")
    @Operation(summary = "Save or update lease term information")
    public Result saveOrUpdate(@RequestBody LeaseTerm leaseTerm) {
        leaseTermService.saveOrUpdate(leaseTerm);
        return Result.ok();
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "Delete lease term by ID")
    public Result deleteLeaseTermById(@RequestParam Long id) {
        boolean b = leaseTermService.removeById(id);
        if (b) {
            return Result.ok();
        }
        return Result.fail();
    }
}
