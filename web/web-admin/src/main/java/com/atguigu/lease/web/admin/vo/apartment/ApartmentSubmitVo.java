package com.atguigu.lease.web.admin.vo.apartment;

import com.atguigu.lease.model.entity.ApartmentInfo;
import com.atguigu.lease.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * Apartment Submission Information
 */
@Schema(description = "Apartment Information for Submission")
@Data
public class ApartmentSubmitVo extends ApartmentInfo {

    @Schema(description="List of Facility Info IDs for the apartment")
    private List<Long> facilityInfoIds;

    @Schema(description="List of Label IDs for the apartment")
    private List<Long> labelIds;

    @Schema(description="List of Fee Value IDs for the apartment")
    private List<Long> feeValueIds;

    @Schema(description="List of Apartment Image IDs")
    private List<GraphVo> graphVoList;

}
