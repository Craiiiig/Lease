package com.atguigu.lease.web.admin.vo.fee;

import com.atguigu.lease.model.entity.FeeValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Fee Value Value Object
 */
@Schema(description = "Fee Value")
@Data
public class FeeValueVo extends FeeValue {

    @Schema(description = "The name of the fee_key corresponding to the fee value")
    private String feeKeyName;
}
