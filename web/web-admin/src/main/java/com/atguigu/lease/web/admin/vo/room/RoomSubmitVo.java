package com.atguigu.lease.web.admin.vo.room;

import com.atguigu.lease.model.entity.RoomInfo;
import com.atguigu.lease.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * Room Information Submission Entity
 */
@Data
@Schema(description = "Room Information Submission Entity")
public class RoomSubmitVo extends RoomInfo {

    @Schema(description = "List of Images")
    private List<GraphVo> graphVoList;

    @Schema(description = "List of Attribute Information IDs")
    private List<Long> attrValueIds;

    @Schema(description = "List of Facility Information IDs")
    private List<Long> facilityInfoIds;

    @Schema(description = "List of Label Information IDs")
    private List<Long> labelInfoIds;

    @Schema(description = "List of Payment Type IDs")
    private List<Long> paymentTypeIds;

    @Schema(description = "List of Available Lease Term IDs")
    private List<Long> leaseTermIds;

}
