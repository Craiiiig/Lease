package com.atguigu.lease.web.admin.service.impl;

import com.atguigu.lease.model.entity.*;
import com.atguigu.lease.model.enums.ItemType;
import com.atguigu.lease.web.admin.mapper.*;
import com.atguigu.lease.web.admin.service.*;
import com.atguigu.lease.web.admin.vo.attr.AttrValueVo;
import com.atguigu.lease.web.admin.vo.graph.GraphVo;
import com.atguigu.lease.web.admin.vo.room.RoomDetailVo;
import com.atguigu.lease.web.admin.vo.room.RoomItemVo;
import com.atguigu.lease.web.admin.vo.room.RoomQueryVo;
import com.atguigu.lease.web.admin.vo.room.RoomSubmitVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liubo
 * @description 针对表【room_info(房间信息表)】的数据库操作Service实现
 * @createDate 2023-07-24 15:48:00
 */
@Service
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
        implements RoomInfoService {

    // Mappers
    @Autowired
    private RoomInfoMapper roomInfoMapper;
    @Autowired
    private GraphInfoMapper graphInfoMapper;
    @Autowired
    private AttrValueMapper attrValueMapper;
    @Autowired
    private FacilityInfoMapper facilityMapper;
    @Autowired
    private LabelInfoMapper labelInfoMapper;
    @Autowired
    private PaymentTypeMapper paymentTypeMapper;
    @Autowired
    private LeaseTermMapper leaseTermMapper;
    @Autowired
    private ApartmentInfoMapper apartmentInfoMapper;

    // Services
    @Autowired
    private GraphInfoService graphInfoService;

    @Autowired
    private RoomAttrValueService roomAttrValueService;

    @Autowired
    private RoomFacilityService roomFacilityService;

    @Autowired
    private RoomLabelService roomLabelService;

    @Autowired
    private RoomPaymentTypeService roomPaymentTypeService;

    @Autowired
    private RoomLeaseTermService roomLeaseTermService;

    /**
     * Remove rooms by apartment ID
     *
     * @param id apartment ID
     */
    @Override
    public void removeByApartmentId(Long id) {
        roomInfoMapper.removeByApartmentId(id);
    }

    @Override
    public void saveOrUpdateRoomInfo(RoomSubmitVo roomSubmitVo) {
        super.save(roomSubmitVo);
        if (roomSubmitVo.getId() != null) {
            // Delete existing records
            QueryWrapper<GraphInfo> graphInfoQueryWrapper = new QueryWrapper<>();
            graphInfoQueryWrapper.eq("item_id", roomSubmitVo.getId());
            graphInfoQueryWrapper.eq("item_type", ItemType.ROOM);
            graphInfoService.remove(graphInfoQueryWrapper);

            QueryWrapper<RoomAttrValue> roomAttrValueQueryWrapper = new QueryWrapper<>();
            roomAttrValueQueryWrapper.eq("room_id", roomSubmitVo.getId());
            roomAttrValueService.remove(roomAttrValueQueryWrapper);

            QueryWrapper<RoomFacility> roomFacilityQueryWrapper = new QueryWrapper<>();
            roomFacilityQueryWrapper.eq("room_id", roomSubmitVo.getId());
            roomFacilityService.remove(roomFacilityQueryWrapper);

            QueryWrapper<RoomLabel> roomLabelQueryWrapper = new QueryWrapper<>();
            roomLabelQueryWrapper.eq("room_id", roomSubmitVo.getId());
            roomLabelService.remove(roomLabelQueryWrapper);

            QueryWrapper<RoomPaymentType> roomPaymentTypeQueryWrapper = new QueryWrapper<>();
            roomPaymentTypeQueryWrapper.eq("room_id", roomSubmitVo.getId());
            roomPaymentTypeService.remove(roomPaymentTypeQueryWrapper);

            QueryWrapper<RoomLeaseTerm> roomLeaseTermQueryWrapper = new QueryWrapper<>();
            roomLeaseTermQueryWrapper.eq("room_id", roomSubmitVo.getId());
            roomLeaseTermService.remove(roomLeaseTermQueryWrapper);
        }
        // Insert new records
        // Non-builder mode
        List<GraphVo> graphInfoList = roomSubmitVo.getGraphVoList();
        ArrayList<GraphInfo> graphInfoInfoList = new ArrayList<>();
        for (GraphVo graphVo : graphInfoList) {
            GraphInfo graphInfo = new GraphInfo();
            graphInfo.setUrl(graphVo.getUrl());
            graphInfo.setName(graphVo.getName());
            graphInfo.setItemType(ItemType.ROOM);
            graphInfo.setItemId(roomSubmitVo.getId());
            graphInfoInfoList.add(graphInfo);
        }


        List<Long> attrValueIds = roomSubmitVo.getAttrValueIds();
        List<RoomAttrValue> roomAttrValueList = new ArrayList<>();
        for (Long attrValueId : attrValueIds) {
            RoomAttrValue roomAttrValue = new RoomAttrValue();
            roomAttrValue.setId(roomSubmitVo.getId());
            roomAttrValue.setAttrValueId(attrValueId);
            roomAttrValueList.add(roomAttrValue);
        }

        // Builder mode
        // If you want to use regular setter, you need to remove @Builder in the entity class
        List<Long> facilityInfoIds = roomSubmitVo.getFacilityInfoIds();
        List<RoomFacility> roomFacilityList = new ArrayList<>();
        for (Long facilityInfoId : facilityInfoIds) {
            RoomFacility roomFacility = RoomFacility.builder()
                    .roomId(roomSubmitVo.getId())
                    .facilityId(facilityInfoId)
                    .build();
            roomFacilityList.add(roomFacility);
        }

        List<Long> labelInfoIds = roomSubmitVo.getLabelInfoIds();
        List<RoomLabel> roomLabelList = new ArrayList<>();
        for (Long labelInfoId : labelInfoIds) {
            RoomLabel roomLabel = RoomLabel.builder()
                    .roomId(roomSubmitVo.getId())
                    .labelId(labelInfoId)
                    .build();
            roomLabelList.add(roomLabel);
        }

        List<Long> paymentTypeIds = roomSubmitVo.getPaymentTypeIds();
        List<RoomPaymentType> roomPaymentTypeList = new ArrayList<>();
        for (Long paymentTypeId : paymentTypeIds) {
            RoomPaymentType roomPaymentType = RoomPaymentType.builder()
                    .paymentTypeId(paymentTypeId)
                    .roomId(roomSubmitVo.getId())
                    .build();
            roomPaymentTypeList.add(roomPaymentType);
        }

        List<Long> leaseTermIds = roomSubmitVo.getLeaseTermIds();
        List<RoomLeaseTerm> roomLeaseTermList = new ArrayList<>();
        for (Long leaseTermId : leaseTermIds) {
            RoomLeaseTerm roomLeaseTerm = RoomLeaseTerm.builder()
                    .roomId(roomSubmitVo.getId())
                    .leaseTermId(leaseTermId).build();
            roomLeaseTermList.add(roomLeaseTerm);

        }
        graphInfoService.saveBatch(graphInfoInfoList);
        roomAttrValueService.saveBatch(roomAttrValueList);
        roomFacilityService.saveBatch(roomFacilityList);
        roomLabelService.saveBatch(roomLabelList);
        roomPaymentTypeService.saveBatch(roomPaymentTypeList);
        roomLeaseTermService.saveBatch(roomLeaseTermList);
    }

    @Override
    public IPage<RoomItemVo> pageRoomItemByQuery(IPage<RoomItemVo> page, RoomQueryVo queryVo) {
        return roomInfoMapper.pageRoomItemByQuery(page, queryVo);
    }

    /**
     * Get Room details by Room id
     *
     * @param id Room ID
     * @return Room detail
     */
    @Override
    public RoomDetailVo getRoomDetailById(Long id) {
        RoomDetailVo roomDetailVo = new RoomDetailVo();
        RoomInfo roomInfo = roomInfoMapper.selectById(id);
        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(roomInfo.getApartmentId());
        List<GraphVo> graphVoList = graphInfoMapper.getListByItemTypeAndId(ItemType.ROOM, id);
        List<AttrValueVo> attrValueVoList = attrValueMapper.getAttrValueById(id);
        List<FacilityInfo> facilityInfoList = facilityMapper.getFacilityListByRoomId(id);
        List<LabelInfo> labelInfoList = labelInfoMapper.getLabelListByRoomId(id);
        List<PaymentType> paymentTypeList = paymentTypeMapper.getPaymentTypeListByRoomId(id);
        List<LeaseTerm> leaseTermList = leaseTermMapper.getLeaseTermListByRoomId(id);

        // Set RoomInfo
        roomDetailVo.setId(roomInfo.getId());
        roomDetailVo.setRoomNumber(roomInfo.getRoomNumber());
        roomDetailVo.setRent(roomInfo.getRent());
        roomDetailVo.setApartmentId(roomInfo.getApartmentId());
        roomDetailVo.setIsRelease(roomInfo.getIsRelease());
        roomDetailVo.setCreateTime(roomInfo.getCreateTime());
        roomDetailVo.setUpdateTime(roomInfo.getUpdateTime());
        roomDetailVo.setIsDeleted(roomInfo.getIsDeleted());

        // Set other data
        roomDetailVo.setApartmentInfo(apartmentInfo);
        roomDetailVo.setGraphVoList(graphVoList);
        roomDetailVo.setAttrValueVoList(attrValueVoList);
        roomDetailVo.setFacilityInfoList(facilityInfoList);
        roomDetailVo.setLabelInfoList(labelInfoList);
        roomDetailVo.setPaymentTypeList(paymentTypeList);
        roomDetailVo.setLeaseTermList(leaseTermList);
        System.err.println(roomDetailVo);
        return roomDetailVo;
    }

    @Override
    public void removeRoomById(Long id) {
        // Remove room from room_info
        super.removeById(id);
        // Remove other data associated with the room
        // 1. Remove image list
        QueryWrapper<GraphInfo> graphInfoQueryWrapper = new QueryWrapper<>();
        graphInfoQueryWrapper.eq("item_id", id);
        graphInfoQueryWrapper.eq("item_type", ItemType.ROOM);
        graphInfoService.remove(graphInfoQueryWrapper);

        // 2. Remove attribute value
        QueryWrapper<RoomAttrValue> roomAttrValueQueryWrapper = new QueryWrapper<>();
        roomAttrValueQueryWrapper.eq("room_id", id);
        roomAttrValueService.remove(roomAttrValueQueryWrapper);

        // 3. Remove facility
        QueryWrapper<RoomFacility> roomFacilityQueryWrapper = new QueryWrapper<>();
        roomFacilityQueryWrapper.eq("room_id", id);
        roomFacilityService.remove(roomFacilityQueryWrapper);

        // 4. Remove labelInfo
        QueryWrapper<RoomLabel> roomLabelQueryWrapper = new QueryWrapper<>();
        roomLabelQueryWrapper.eq("room_id", id);
        roomLabelService.remove(roomLabelQueryWrapper);

        // 5. Remove paymentType
        QueryWrapper<RoomPaymentType> roomPaymentTypeQueryWrapper = new QueryWrapper<>();
        roomPaymentTypeQueryWrapper.eq("room_id", id);
        roomPaymentTypeService.remove(roomPaymentTypeQueryWrapper);

        // 6. Remove leaseTerm
        QueryWrapper<RoomLeaseTerm> roomLeaseTermQueryWrapper = new QueryWrapper<>();
        roomLeaseTermQueryWrapper.eq("room_id", id);
        roomLeaseTermService.remove(roomLeaseTermQueryWrapper);
    }
}




