package com.atguigu.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LeaseStatus implements BaseEnum {

    SIGNING(1, "Agreement Pending Confirmation"),
    SIGNED(2, "Agreement Signed"),
    CANCELED(3, "Agreement Canceled"),
    EXPIRED(4, "Agreement Expired"),
    WITHDRAWING(5, "Termination Pending Confirmation"),
    WITHDRAWN(6, "Agreement Terminated"),
    RENEWING(7, "Renewal Pending Confirmation");


    @EnumValue
    @JsonValue
    private Integer code;

    private String name;

    LeaseStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
