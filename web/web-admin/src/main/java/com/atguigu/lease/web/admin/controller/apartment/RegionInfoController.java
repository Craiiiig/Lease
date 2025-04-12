package com.atguigu.lease.web.admin.controller.apartment;

import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.model.entity.CityInfo;
import com.atguigu.lease.model.entity.DistrictInfo;
import com.atguigu.lease.model.entity.ProvinceInfo;
import com.atguigu.lease.web.admin.service.CityInfoService;
import com.atguigu.lease.web.admin.service.DistrictInfoService;
import com.atguigu.lease.web.admin.service.ProvinceInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Region Information Management")
@RestController
@RequestMapping("/admin/region")
public class RegionInfoController {

    @Autowired
    private ProvinceInfoService provinceInfoService;
    @Autowired
    private CityInfoService cityInfoService;
    @Autowired
    private DistrictInfoService districtInfoService;

    @Operation(summary = "Query Province Information List")
    @GetMapping("province/list")
    public Result<List<ProvinceInfo>> listProvince() {
        List<ProvinceInfo> provinceInfoList = provinceInfoService.list();
        return Result.ok(provinceInfoList);
    }

    @Operation(summary = "Query City Information List by Province ID")
    @GetMapping("city/listByProvinceId")
    public Result<List<CityInfo>> listCityInfoByProvinceId(@RequestParam Long id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("province_id", id);
        List<CityInfo> cityInfoList = cityInfoService.list(queryWrapper);
        return Result.ok(cityInfoList);
    }

    @GetMapping("district/listByCityId")
    @Operation(summary = "Query District Information by City ID")
    public Result<List<DistrictInfo>> listDistrictInfoByCityId(@RequestParam Long id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("city_id", id);
        List<DistrictInfo> districtInfoList = districtInfoService.list(queryWrapper);
        return Result.ok(districtInfoList);
    }

}
