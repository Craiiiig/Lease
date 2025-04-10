package com.atguigu.lease.web.admin.vo.room;

import com.atguigu.lease.model.entity.ApartmentInfo;
import com.atguigu.lease.model.entity.RoomInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * Room Information
 */
@Data
@Schema(description = "Room Information")
public class RoomItemVo extends RoomInfo {

    @Schema(description = "Lease End Date")
    private Date leaseEndDate;

    @Schema(description = "Current Check-in Status")
    private Boolean isCheckIn;

    @Schema(description = "Belonging Apartment Information")
    private ApartmentInfo apartmentInfo;
}
