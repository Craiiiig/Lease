package com.atguigu.lease.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Room & Payment Type Relationship Table")
@TableName(value = "room_payment_type")
@Data
@Builder
public class RoomPaymentType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Room ID")
    @TableField(value = "room_id")
    private Long roomId;

    @Schema(description = "Payment Type ID")
    @TableField(value = "payment_type_id")
    private Long paymentTypeId;
}
