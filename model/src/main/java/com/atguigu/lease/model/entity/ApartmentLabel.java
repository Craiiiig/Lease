package com.atguigu.lease.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * Apartment & Label Association Table
 */
@Schema(description = "Apartment Label Association Table")
@TableName(value = "apartment_label")
@Data
public class ApartmentLabel extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Apartment ID")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    @Schema(description = "Label ID")
    @TableField(value = "label_id")
    private Long labelId;

}
