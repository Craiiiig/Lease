package com.atguigu.lease.web.admin.schedule;

import com.atguigu.lease.model.entity.LeaseAgreement;
import com.atguigu.lease.model.enums.LeaseStatus;
import com.atguigu.lease.web.admin.service.LeaseAgreementService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduleTasks {
    @Autowired
    private LeaseAgreementService leaseAgreementService;

    @Scheduled(cron = "0 0 0 * * *") // Schedule to run everyday
    public void checkLeaseStatus() {
        UpdateWrapper<LeaseAgreement> wrapper = new UpdateWrapper<>();
        wrapper.le("lease_end_date", new Date());
        // Signed agreements and withdrawn pending agreements are still in current.
        wrapper.in("status", LeaseStatus.SIGNED, LeaseStatus.WITHDRAWING);
        wrapper.eq("status", LeaseStatus.EXPIRED);
        leaseAgreementService.update(null, wrapper);
    }
}
