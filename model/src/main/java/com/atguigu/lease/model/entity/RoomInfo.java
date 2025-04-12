package com.atguigu.lease.model.entity;

import com.atguigu.lease.model.enums.ReleaseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Schema(description = "Room Information Table")
@TableName(value = "room_info")
@Data
public class RoomInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Room Number")
    @TableField(value = "room_number")
    private String roomNumber;

    @Schema(description = "Rent (Yuan/Month)")
    @TableField(value = "rent")
    private BigDecimal rent;

    @Schema(description = "Belonging Apartment ID")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    @Schema(description = "Is Released")
    @TableField(value = "is_release")
    private ReleaseStatus isRelease;
}
