package com.atguigu.lease.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Schema(description = "Room Attribute Value Table")
@TableName(value = "attr_value")
@Data
public class AttrValue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Attribute Value Name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Corresponding Attribute Key ID") // As a foreign key
    @TableField(value = "attr_key_id")
    private Long attrKeyId;
}
