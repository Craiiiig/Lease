package com.atguigu.lease.model.entity;

import com.atguigu.lease.model.enums.LeaseSourceType;
import com.atguigu.lease.model.enums.LeaseStatus;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Schema(description = "Lease agreement info")
@TableName(value = "lease_agreement")
@Data
public class LeaseAgreement extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Tenant's phone number")
    @TableField(value = "phone")
    private String phone;

    @Schema(description = "Tenant's name")
    @TableField(value = "name")
    private String name;

    @Schema(description = "Tenant's ID number")
    @TableField(value = "identification_number")
    private String identificationNumber;

    @Schema(description = "apartment ID")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    @Schema(description = "Room Id")
    @TableField(value = "room_id")
    private Long roomId;

    @Schema(description = "Lease start date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "lease_start_date")
    private Date leaseStartDate;

    @Schema(description = "Lease end date")
    @TableField(value = "lease_end_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date leaseEndDate;

    @Schema(description = "Lease agreement ID")
    @TableField(value = "lease_term_id")
    private Long leaseTermId;

    @Schema(description = "Rate")
    @TableField(value = "rent")
    private BigDecimal rent;

    @Schema(description = "deposit）")
    @TableField(value = "deposit")
    private BigDecimal deposit;

    @Schema(description = "Payment type id")
    @TableField(value = "payment_type_id")
    private Long paymentTypeId;

    @Schema(description = "Rental status")
    @TableField(value = "status")
    private LeaseStatus status;

    @Schema(description = "Agreement source")
    @TableField(value = "source_type")
    private LeaseSourceType sourceType;

    @Schema(description = "Additional info")
    @TableField(value = "additional_info")
    private String additionalInfo;

}