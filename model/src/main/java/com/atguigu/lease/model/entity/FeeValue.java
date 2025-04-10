package com.atguigu.lease.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Miscellaneous Fee Value Table
 */
@Schema(description = "Miscellaneous Fee Value Table")
@TableName(value = "fee_value")
@Data
public class FeeValue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Fee value name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Billing unit")
    @TableField(value = "unit")
    private String unit;

    @Schema(description = "Associated fee_key ID")
    @TableField(value = "fee_key_id")
    private Long feeKeyId;
}
