package com.atguigu.lease.web.admin.vo.apartment;

import com.atguigu.lease.model.entity.ApartmentInfo;
import com.atguigu.lease.model.entity.FacilityInfo;
import com.atguigu.lease.model.entity.LabelInfo;
import com.atguigu.lease.web.admin.vo.graph.GraphVo;
import com.atguigu.lease.web.admin.vo.fee.FeeValueVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * Apartment Details
 */
@Schema(description = "Apartment Information")
@Data
public class ApartmentDetailVo extends ApartmentInfo {

    @Schema(description = "List of images")
    private List<GraphVo> graphVoList;

    @Schema(description = "List of tags/labels")
    private List<LabelInfo> labelInfoList;

    @Schema(description = "List of facilities")
    private List<FacilityInfo> facilityInfoList;

    @Schema(description = "List of miscellaneous fees")
    private List<FeeValueVo> feeValueVoList;
}
