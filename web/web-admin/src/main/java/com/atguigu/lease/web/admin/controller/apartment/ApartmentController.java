package com.atguigu.lease.web.admin.controller.apartment;

import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.model.entity.ApartmentInfo;
import com.atguigu.lease.model.enums.ReleaseStatus;
import com.atguigu.lease.web.admin.service.ApartmentInfoService;
import com.atguigu.lease.web.admin.vo.apartment.ApartmentDetailVo;
import com.atguigu.lease.web.admin.vo.apartment.ApartmentItemVo;
import com.atguigu.lease.web.admin.vo.apartment.ApartmentQueryVo;
import com.atguigu.lease.web.admin.vo.apartment.ApartmentSubmitVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Apartment Information Management")
@RestController
@RequestMapping("/admin/apartment")
public class ApartmentController {

    @Autowired
    private ApartmentInfoService apartmentInfoService;

    @Operation(summary = "Save or update apartment information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody ApartmentSubmitVo apartmentSubmitVo) {
        apartmentInfoService.saveOrUpdateApartmentInfo(apartmentSubmitVo);
        return Result.ok();
    }

    @Operation(summary = "Paginate apartment list based on query conditions")
    @GetMapping("pageItem")
    public Result<IPage<ApartmentItemVo>> pageItem(@RequestParam long current,
                                                   @RequestParam long size,
                                                   ApartmentQueryVo queryVo) {
        Page<ApartmentItemVo> apartmentItemVoPage = new Page<>(current, size);
        IPage<ApartmentItemVo> result =  apartmentInfoService.pageItem(apartmentItemVoPage, queryVo);
        return Result.ok(result);
    }

    @Operation(summary = "Get detailed apartment info by ID")
    @GetMapping("getDetailById")
    public Result<ApartmentDetailVo> getDetailById(@RequestParam Long id) {

        return Result.ok();
    }

    @Operation(summary = "Delete apartment information by ID")
    @DeleteMapping("removeById")
    public Result removeById(@RequestParam Long id) {
        return Result.ok();
    }

    @Operation(summary = "Update apartment release status by ID")
    @PostMapping("updateReleaseStatusById")
    public Result updateReleaseStatusById(@RequestParam Long id, @RequestParam ReleaseStatus status) {
        return Result.ok();
    }

    @Operation(summary = "Get apartment list by district ID")
    @GetMapping("listInfoByDistrictId")
    public Result<List<ApartmentInfo>> listInfoByDistrictId(@RequestParam Long id) {
        return Result.ok();
    }
}
