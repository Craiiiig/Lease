package com.atguigu.lease.web.admin.vo.room;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Room Query Entity
 */
@Schema(description = "Room Query Entity")
@Data
public class RoomQueryVo {

    @Schema(description = "Province ID")
    private Long provinceId;

    @Schema(description = "City ID")
    private Long cityId;

    @Schema(description = "District ID")
    private Long districtId;

    @Schema(description = "Apartment ID")
    private Long apartmentId;
}
