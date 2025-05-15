import React, { useState } from 'react';
import { Form, Table } from 'antd';
import { columns, data } from '../../../config/tableColumns/apartmentTableColumns';
import LocationFilterForm from '../../../components/locationFilterForm';
import UpdateForm from '../../../components/updateApartmentForm';
import {apartmentId10} from '../../../mock/index'



const ApartmentManagement = () => {
    const [isModalOpen, setIsModalOpen] = useState(false)
    const [form] = Form.useForm();
    const [componentSize, setComponentSize] = useState('default');
    const [editingRecord, setEditingRecord] = useState(null);


    

    const handleChange = value => {
        console.log(`Selected: ${value}`);
      };
    const handleEdit = (record) => {
        // Use to fetch data from the server
        const apartmentID = record.id
        let data = {}
        // Fetch User data
        data.apartmentName = apartmentId10.name
        data.introduction = apartmentId10.introduction
        data.provinceName = apartmentId10.provinceName
        data.cityName = apartmentId10.cityName
        data.districtName = apartmentId10.districtName
        data.addressDetail = apartmentId10.addressDetail
        data.phone = apartmentId10.phone
        data.isRelease = apartmentId10.isRelease
        data.labelInfoList = apartmentId10.labelInfoList
        data.facilityInfoList = apartmentId10.facilityInfoList
        data.feeValueVoList = apartmentId10.feeValueVoList
        setEditingRecord(data);
        console.log(editingRecord)
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

    const handleDelete = (record) => {

        console.log("Delete record:", record);
    }

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
                parentClassName={"ApartmentManagement"}
            />
            <Table
                dataSource={data}
                columns={columns(handleEdit, handleDelete)}
                pagination={false}
                rowKey={"name"} // tableData.name

            />
            <UpdateForm
            
                form={form}
                onFinish={handleOk}
                handleChange={handleChange}
                initialValues={editingRecord}
                setIsModalOpen={setIsModalOpen}
                isModalOpen={isModalOpen}
                
                handleOk={handleOk}
            />
        </div>

    );
}

export default ApartmentManagement;