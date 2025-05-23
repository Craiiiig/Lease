package com.atguigu.lease.web.admin.vo.fee;

import com.atguigu.lease.model.entity.FeeKey;
import com.atguigu.lease.model.entity.FeeValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * Fee Key Value Object
 */
@Data
public class FeeKeyVo extends FeeKey {

    @Schema(description = "List of Fee Values")
    private List<FeeValue> feeValueList;
}
