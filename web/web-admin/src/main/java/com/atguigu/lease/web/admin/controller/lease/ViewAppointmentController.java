package com.atguigu.lease.web.admin.controller.lease;

import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.model.entity.ViewAppointment;
import com.atguigu.lease.model.enums.AppointmentStatus;
import com.atguigu.lease.web.admin.service.ViewAppointmentService;
import com.atguigu.lease.web.admin.vo.appointment.AppointmentQueryVo;
import com.atguigu.lease.web.admin.vo.appointment.AppointmentVo;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "View Appointment Management")
@RequestMapping("/admin/appointment")
@RestController
public class ViewAppointmentController {
    @Autowired
    private ViewAppointmentService viewAppointmentService;

    @Operation(summary = "Paginated query of appointment information")
    @GetMapping("page")
    public Result<IPage<AppointmentVo>> page(@RequestParam long current,
                                             @RequestParam long size,
                                             AppointmentQueryVo queryVo) {
        Page<AppointmentVo> page = new Page<>(current, size);
       IPage<AppointmentVo> result =  viewAppointmentService.pageAppointment(page, queryVo);
        return Result.ok(result);
    }

    @Operation(summary = "Update appointment status by ID")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam AppointmentStatus status) {
        UpdateWrapper<ViewAppointment> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", id);
        wrapper.set("appointment_status", status);
        viewAppointmentService.update(wrapper);
        return Result.ok();
    }

}
