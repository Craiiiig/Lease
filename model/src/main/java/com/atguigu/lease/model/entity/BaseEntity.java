package com.atguigu.lease.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable { // Catch to Redis

    @Schema(description = "Primary key")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "Creation time")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @Schema(description = "Update time")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    @Schema(description = "Logical delete")
    @TableField("is_deleted")
    private Byte isDeleted;

}
