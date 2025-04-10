package com.atguigu.lease.web.admin.vo.apartment;

import com.atguigu.lease.model.entity.ApartmentInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Apartment List Entity for the Admin Backend System
 */
@Data
@Schema(description = "Apartment List Entity for the Admin Backend System")
public class ApartmentItemVo extends ApartmentInfo {

    @Schema(description = "Total number of rooms")
    private Long totalRoomCount;

    @Schema(description = "Number of free rooms")
    private Long freeRoomCount;

}
