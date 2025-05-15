import React, { useState } from "react";
import { columns } from "../../../config/tableColumns/roomManagementTableColumn";
import { facilities, roomList } from "../../../mock/index"
import { Table, Form } from "antd";
import UpdateForm from "../../../components/updateApartmentForm";
import { roomId3 } from "../../../mock/index";

import LocationFilterForm from "../../../components/locationFilterForm";

const RoomManagement = () => {
    const [isModalOpen, setIsModalOpen] = useState(false)
    const [form] = Form.useForm();
    const [componentSize, setComponentSize] = useState('default');
    const [editingRecord, setEditingRecord] = useState(null);

    const handleEdit = (record) => {
        const roomID = record.id
        let data = {}
        data.roomNumber = roomId3.roomNumber
        data.rent = roomId3.rent
        data.provinceName = roomId3.apartmentInfo.provinceName
        data.provinceId = roomId3.apartmentInfo.provinceId
        data.cityName = roomId3.apartmentInfo.cityName
        data.cityId = roomId3.apartmentInfo.cityId
        data.districtName = roomId3.apartmentInfo.districtName
        data.districtId = roomId3.apartmentInfo.districtId
        data.apartmentName = roomId3.apartmentInfo.name
        data.apartmentId = roomId3.apartmentInfo.id
        data.isRelease = roomId3.isRelease
        data.attrValueVoList = roomId3.attrValueVoList
        data.facilityInfoList = roomId3.facilityInfoList
        data.labelInfoList = roomId3.labelInfoList
        data.paymentTypeList = roomId3.paymentTypeList
        data.leaseTermList = roomId3.leaseTermList

        setEditingRecord(data);
        form.setFieldsValue(data);
        setIsModalOpen(true);
    };

    // Submit updated data or save new data
    const handleOk = () => {
        form.validateFields()
            .then((values) => {

                setIsModalOpen(false);
                form.resetFields();
            })
            .catch((info) => {

            });
    };

    const handleCancel = () => {
        setIsModalOpen(false);
        form.resetFields();
    };
    const handleDelete = (record) => {

        console.log("Delete record:", record);
    }

    const options = facilities.filter(item => item.type === 2).map(item => {{
        return {
            id: item.id,
            label: item.name,
            value: item.name,
        }
    }})
    console.log(options)


    const onFormLayoutChange = ({ size }) => {
        setComponentSize(size);
    };

    const showModal = () => {
        setIsModalOpen(true);
    }

    return (
        <div>
            <LocationFilterForm
                componentSize={componentSize}
                onFormLayoutChange={onFormLayoutChange}
                showModal={showModal}
                parentClassName={"RoomManagement"}
            />
            <Table
                dataSource={roomList}
                columns={columns(handleEdit, handleDelete)}
                pagination={false}
                rowKey={"name"} // tableData.name

            />
            <UpdateForm
                form={form}
                onFinish={handleOk}
                onFinishFailed={handleCancel}
                initialValues={editingRecord}
                setIsModalOpen={setIsModalOpen}
                isModalOpen={isModalOpen}
                options={options}
                handleOk={handleOk}
                roomOrApartment={"Room"}
            />
        </div>

    );
}
export default RoomManagement;