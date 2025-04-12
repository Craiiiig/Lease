package com.atguigu.lease.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.atguigu.lease.model.enums.ItemType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Schema(description = "Image Information Table")
@TableName(value = "graph_info")
@Data
public class GraphInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Image name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Type of item the image is associated with")
    @TableField(value = "item_type")
    private ItemType itemType;

    @Schema(description = "ID of the item the image belongs to")
    @TableField(value = "item_id")
    private Long itemId;

    @Schema(description = "Image URL")
    @TableField(value = "url")
    private String url;

}
