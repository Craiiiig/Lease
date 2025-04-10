package com.atguigu.lease.web.admin.vo.room;

import com.atguigu.lease.model.entity.*;
import com.atguigu.lease.web.admin.vo.attr.AttrValueVo;
import com.atguigu.lease.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * Room Information
 */
@Schema(description = "Room Information")
@Data
public class RoomDetailVo extends RoomInfo {

    @Schema(description = "Belonging Apartment Information")
    private ApartmentInfo apartmentInfo;

    @Schema(description = "List of Images")
    private List<GraphVo> graphVoList;

    @Schema(description = "List of Attribute Information")
    private List<AttrValueVo> attrValueVoList;

    @Schema(description = "List of Facility Information")
    private List<FacilityInfo> facilityInfoList;

    @Schema(description = "List of Label Information")
    private List<LabelInfo> labelInfoList;

    @Schema(description = "List of Payment Types")
    private List<PaymentType> paymentTypeList;

    @Schema(description = "List of Optional Lease Terms")
    private List<LeaseTerm> leaseTermList;
}
