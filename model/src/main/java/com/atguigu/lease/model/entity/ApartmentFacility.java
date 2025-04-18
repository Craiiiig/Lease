package com.atguigu.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * Apartment and Facility Relationship Entity
 */
@Schema(description = "Apartment and Facility Relationship")
@TableName(value = "apartment_facility")
@Data
public class ApartmentFacility extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Apartment ID")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    @Schema(description = "Facility ID")
    @TableField(value = "facility_id")
    private Long facilityId;

}
