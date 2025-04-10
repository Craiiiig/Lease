package com.atguigu.lease.web.admin.vo.appointment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Appointment Viewing Query Entity
 */
@Data
@Schema(description = "Appointment Viewing Query Entity")
public class AppointmentQueryVo {

    @Schema(description="Province of the apartment being viewed")
    private Long provinceId;

    @Schema(description="City of the apartment being viewed")
    private Long cityId;

    @Schema(description="District of the apartment being viewed")
    private Long districtId;

    @Schema(description="Apartment ID of the appointment")
    private Long apartmentId;

    @Schema(description="Name of the appointment user")
    private String name;

    @Schema(description="Phone number of the appointment user")
    private String phone;
}
