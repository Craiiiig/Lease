package com.atguigu.lease.web.admin.controller.apartment;

import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.model.entity.RoomInfo;
import com.atguigu.lease.model.enums.ReleaseStatus;
import com.atguigu.lease.web.admin.service.RoomInfoService;
import com.atguigu.lease.web.admin.vo.room.RoomDetailVo;
import com.atguigu.lease.web.admin.vo.room.RoomItemVo;
import com.atguigu.lease.web.admin.vo.room.RoomQueryVo;
import com.atguigu.lease.web.admin.vo.room.RoomSubmitVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Room Information Management")
@RestController
@RequestMapping("/admin/room")
public class RoomController {
    @Autowired
    private RoomInfoService roomInfoService;

    @Operation(summary = "Save or update room information")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody RoomSubmitVo roomSubmitVo) {
        roomInfoService.saveOrUpdateRoomInfo(roomSubmitVo);
        return Result.ok();
    }

    @Operation(summary = "Get paginated room list by conditions")
    @GetMapping("pageItem")
    public Result<IPage<RoomItemVo>> pageItem(@RequestParam long current, @RequestParam long size, RoomQueryVo queryVo) {
        IPage<RoomItemVo> page = new Page<>(current, size);
        IPage<RoomItemVo> result = roomInfoService.pageRoomItemByQuery(page, queryVo);
        return Result.ok(result);
    }

    @Operation(summary = "Get room details by ID")
    @GetMapping("getDetailById")
    public Result<RoomDetailVo> getDetailById(@RequestParam Long id) {
        RoomDetailVo roomDetailVo = roomInfoService.getRoomDetailById(id);
        return Result.ok(roomDetailVo);
    }

    @Operation(summary = "Delete room information by ID")
    @DeleteMapping("removeById")
    public Result removeById(@RequestParam Long id) {
        roomInfoService.removeRoomById(id);
        return Result.ok();
    }

    @Operation(summary = "Update room release status by ID")
    @PostMapping("updateReleaseStatusById")
    public Result updateReleaseStatusById(Long id, ReleaseStatus status) {
        UpdateWrapper<RoomInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        updateWrapper.eq("is_release", status);
        roomInfoService.update(updateWrapper);
        return Result.ok();
    }

    /**
     * Get room list by apartment ID
     *
     * @param id apartment ID
     * @return a list of rooms that belong to the apartment
     */
    @GetMapping("listBasicByApartmentId")
    @Operation(summary = "Get room list by apartment ID")
    public Result<List<RoomInfo>> listBasicByApartmentId(Long id) {
        QueryWrapper<RoomInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("apartment_id", id);
        queryWrapper.eq("is_release", ReleaseStatus.RELEASED);
        List<RoomInfo> roomInfoList = roomInfoService.list(queryWrapper);
        return Result.ok(roomInfoList);
    }
}
