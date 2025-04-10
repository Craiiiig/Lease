package com.atguigu.lease.web.admin.vo.attr;

import com.atguigu.lease.model.entity.AttrKey;
import com.atguigu.lease.model.entity.AttrValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * Attribute Key Value Object
 */
@Data
public class AttrKeyVo extends AttrKey {

    @Schema(description = "List of Attribute Values")
    private List<AttrValue> attrValueList;
}
