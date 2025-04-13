package com.atguigu.lease.web.admin.service.impl;

import com.atguigu.lease.model.entity.*;
import com.atguigu.lease.model.enums.ItemType;
import com.atguigu.lease.web.admin.mapper.*;
import com.atguigu.lease.web.admin.service.*;
import com.atguigu.lease.web.admin.vo.apartment.ApartmentDetailVo;
import com.atguigu.lease.web.admin.vo.apartment.ApartmentItemVo;
import com.atguigu.lease.web.admin.vo.apartment.ApartmentQueryVo;
import com.atguigu.lease.web.admin.vo.apartment.ApartmentSubmitVo;
import com.atguigu.lease.web.admin.vo.fee.FeeValueVo;
import com.atguigu.lease.web.admin.vo.graph.GraphVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liubo
 * @description 针对表【apartment_info(公寓信息表)】的数据库操作Service实现
 * @createDate 2023-07-24 15:48:00
 */
@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
        implements ApartmentInfoService {

    @Autowired
    private ApartmentInfoMapper apartmentInfoMapper;

    @Autowired
    private GraphInfoMapper graphInfoMapper;

    @Autowired
    private LabelInfoMapper labelInfoMapper;

    @Autowired
    private FacilityInfoMapper facilityInfoMapper;

    @Autowired
    private FeeValueMapper feeValueMapper;

    @Autowired
    private GraphInfoService graphInfoService;

    @Autowired
    private ApartmentFacilityService apartmentFacilityService;

    @Autowired
    private ApartmentLabelService apartmentLabelService;

    @Autowired
    private ApartmentFeeValueService apartmentFeeValueService;

    @Autowired
    private RoomInfoService roomInfoService;


    /**
     * Insert new or update exist apartment info
     * - If insert new apartment info, save directly.
     * - If update existing apartment info, delete records first, them insert all.
     *
     * @param apartmentSubmitVo Apartment info
     */
    @Override
    public void saveOrUpdateApartmentInfo(ApartmentSubmitVo apartmentSubmitVo) {

        if (apartmentSubmitVo.getId() != null) {  // Update new data
            // Remove image list
            QueryWrapper<GraphInfo> graphQueryWrapper = new QueryWrapper<>();
            graphQueryWrapper.eq("item_type", ItemType.APARTMENT);
            graphQueryWrapper.eq("item_id", apartmentSubmitVo.getId());
            graphInfoService.remove(graphQueryWrapper);

            // Remove facility list
            QueryWrapper<ApartmentFacility> apartmentFacilityQueryWrapper = new QueryWrapper<>();
            apartmentFacilityQueryWrapper.eq("apartment_id", apartmentSubmitVo.getId());
            apartmentFacilityService.remove(apartmentFacilityQueryWrapper);

            // Remove label list
            QueryWrapper<ApartmentLabel> apartmentLabelQueryWrapper = new QueryWrapper<ApartmentLabel>();
            apartmentLabelQueryWrapper.eq("apartment_id", apartmentSubmitVo.getId());
            apartmentLabelService.remove(apartmentLabelQueryWrapper);

            // Remove fee list
            QueryWrapper<ApartmentFeeValue> apartmentFeeValueQueryWrapper = new QueryWrapper<ApartmentFeeValue>();
            apartmentFeeValueQueryWrapper.eq("apartment_id", apartmentSubmitVo.getId());
            apartmentFeeValueService.remove(apartmentFeeValueQueryWrapper);
        }

        // Insert image list
        List<GraphVo> graphVoList = apartmentSubmitVo.getGraphVoList();
        // Graph info contains itemType and itemId that GraphVo DOES NOT have
        ArrayList<GraphInfo> graphInfosList = new ArrayList<>();
        for (GraphVo graphVo : graphVoList) {
            GraphInfo graphInfo = new GraphInfo();
            graphInfo.setItemType(ItemType.APARTMENT);
            graphInfo.setItemId(apartmentSubmitVo.getId());
            graphInfo.setName(graphVo.getName());
            graphInfo.setUrl(graphVo.getUrl());
            graphInfosList.add(graphInfo);
        }
        graphInfoService.saveBatch(graphInfosList);

        // Insert facility list
        List<Long> facilityInfoIdList = apartmentSubmitVo.getFacilityInfoIds();
        ArrayList<ApartmentFacility> apartmentFacilityList = new ArrayList<>();
        for (Long facilityId : facilityInfoIdList) {
            ApartmentFacility apartmentFacility = new ApartmentFacility();
            apartmentFacility.setFacilityId(facilityId);
            apartmentFacility.setApartmentId(apartmentSubmitVo.getId());
            apartmentFacilityList.add(apartmentFacility);
        }
        apartmentFacilityService.saveBatch(apartmentFacilityList);
        // Insert label list
        List<Long> labelIds = apartmentSubmitVo.getLabelIds();
        ArrayList<ApartmentLabel> apartmentLabelList = new ArrayList<>();
        for (Long labelId : labelIds) {
            ApartmentLabel apartmentLabel = new ApartmentLabel();
            apartmentLabel.setLabelId(labelId);
            apartmentLabel.setApartmentId(apartmentSubmitVo.getId());
            apartmentLabelList.add(apartmentLabel);
        }
        apartmentLabelService.saveBatch(apartmentLabelList);
        // Insert fee list
        List<Long> feeIds = apartmentSubmitVo.getFeeValueIds();
        ArrayList<ApartmentFeeValue> apartmentFeeValueList = new ArrayList<>();
        for (Long feeId : feeIds) {
            ApartmentFeeValue apartmentFeeValue = new ApartmentFeeValue();
            apartmentFeeValue.setApartmentId(apartmentSubmitVo.getId());
            apartmentFeeValue.setFeeValueId(feeId);
            apartmentFeeValueList.add(apartmentFeeValue);
        }
        apartmentFeeValueService.saveBatch(apartmentFeeValueList);
        super.saveOrUpdate(apartmentSubmitVo);
    }

    @Override
    public IPage<ApartmentItemVo> pageItem(Page<ApartmentItemVo> page, ApartmentQueryVo queryVo) {

        return apartmentInfoMapper.pageItem(page, queryVo);
    }

    /**
     * @param id apartment id
     * @return
     */
    @Override
    public ApartmentDetailVo getDetailById(Long id) {
        // 1. Query apartment info
        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(id);

        // 2. query image list
        List<GraphVo> graphVoList = graphInfoMapper.getListByItemTypeAndId(ItemType.APARTMENT, id);

        // 3. query label list
        List<LabelInfo> labelInfoList = labelInfoMapper.getLabelListByApartmentId(id);
        // 4. query facility list
        List<FacilityInfo> facilityInfoList = facilityInfoMapper.getFacilityListByApartmentId(id);
        // 5. query fee list
        List<FeeValueVo> feeValueVoList = feeValueMapper.getFeeValueListByApartmentId();
        // 6. Assemble result
        ApartmentDetailVo apartmentDetailVo = new ApartmentDetailVo();

        BeanUtils.copyProperties(apartmentInfo, apartmentDetailVo);
        apartmentDetailVo.setGraphVoList(graphVoList);
        apartmentDetailVo.setLabelInfoList(labelInfoList);
        apartmentDetailVo.setFacilityInfoList(facilityInfoList);
        apartmentDetailVo.setFeeValueVoList(feeValueVoList);

        return apartmentDetailVo;
    }

    /**
     * Remove apartment.
     * If any rooms of this apartment exist, those rooms would be removed.
     * @param id Apartment Id
     */
    @Transactional()
    @Override
    public void removeApartmentById(Long id) {
        // 1. Remove apartment info
        boolean b = super.removeById(id);
        System.err.println(b);
        // 2. Remove corresponding image info
        QueryWrapper<GraphInfo> graphInfoQueryWrapper = new QueryWrapper<>();
        graphInfoQueryWrapper.eq("item_id", id).eq("item_type", ItemType.APARTMENT);
        graphInfoService.remove(graphInfoQueryWrapper);

        // 3. Remove corresponding facility info
        QueryWrapper<ApartmentFacility> facilityInfoQueryWrapper = new QueryWrapper<>();
        facilityInfoQueryWrapper.eq("apartment_id", id);
        apartmentFacilityService.remove(facilityInfoQueryWrapper);
        // 4. Remove corresponding label info
        QueryWrapper<ApartmentLabel> apartmentLabelQueryWrapper = new QueryWrapper<>();
        apartmentLabelQueryWrapper.eq("apartment_id", id);
        apartmentLabelService.remove(apartmentLabelQueryWrapper);

        // 5. Remove corresponding fee info
        QueryWrapper<ApartmentFeeValue> apartmentFeeValueQueryWrapper = new QueryWrapper<>();
        apartmentFeeValueQueryWrapper.eq("apartment_id", id);
        apartmentFeeValueService.remove(apartmentFeeValueQueryWrapper);

        // Remove rooms
        roomInfoService.removeByApartmentId(id);
    }
}




