package com.atguigu.lease.web.admin.vo.appointment;

import com.atguigu.lease.model.entity.ApartmentInfo;
import com.atguigu.lease.model.entity.ViewAppointment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Appointment Viewing Information
 */
@Data
@Schema(description = "Appointment Viewing Information")
public class AppointmentVo extends ViewAppointment {

    @Schema(description = "Apartment Information for the appointment")
    private ApartmentInfo apartmentInfo;

}
