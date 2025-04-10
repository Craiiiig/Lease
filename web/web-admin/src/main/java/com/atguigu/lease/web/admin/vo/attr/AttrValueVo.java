package com.atguigu.lease.web.admin.vo.attr;

import com.atguigu.lease.model.entity.AttrValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Attribute Value Value Object
 */
@Schema(description = "Attribute Value")
@Data
public class AttrValueVo extends AttrValue {

    @Schema(description = "Corresponding Attribute Key Name")
    private String attrKeyName;
}
