package com.atguigu.lease.web.admin.mapper;

import com.atguigu.lease.model.entity.FacilityInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author liubo
* @description 针对表【facility_info(配套信息表)】的数据库操作Mapper
* @createDate 2023-07-24 15:48:00
* @Entity com.atguigu.lease.model.FacilityInfo
*/

public interface FacilityInfoMapper extends BaseMapper<FacilityInfo> {

    List<FacilityInfo> getFacilityListByApartmentId(Long id);

    List<FacilityInfo> getFacilityListByRoomId(Long id);
}




