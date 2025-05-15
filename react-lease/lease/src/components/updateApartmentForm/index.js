
import React, { useEffect } from 'react';
import { Form, Select, Modal, Input, Radio } from 'antd';
import AreaSelector from '../locationSelection';
import { facilities as facilityList } from '../../mock/index';
const UpdateForm = ({ form, setIsModalOpen, isModalOpen, handleChange, initialValues, roomOrApartment }) => {

    const handleCancelInternal = () => {
        setIsModalOpen(false);
        form.resetFields();
    };
    const formType = roomOrApartment === 'Room' ? 'room' : 'apartment';

    console.log(roomOrApartment)


    useEffect(() => {
        if (initialValues) {
            form.setFieldsValue({
                roomNumber: initialValues.roomNumber,
                rental: initialValues.rent,
                provinceName: initialValues.provinceName,
                provinceId: initialValues.provinceId,
                cityName: initialValues.cityName,
                cityId: initialValues.cityId,
                districtName: initialValues.districtName,
                districtId: initialValues.districtId,
                apartmentId: initialValues.apartmentId,
                apartmentInfo: initialValues.apartmentInfo,
                apartmentInfoId: initialValues.apartmentInfoId,
                apartmentInfoName: initialValues.apartmentInfoName,
                apartmentInfoDistrictId: initialValues.apartmentInfoDistrictId,
                apartmentInfoDistrictName: initialValues.apartmentInfoDistrictName,
                apartmentInfoCityId: initialValues.apartmentInfoCityId,
                apartmentInfoCityName: initialValues.apartmentInfoCityName,
                apartmentInfoProvinceId: initialValues.apartmentInfoProvinceId,
                apartmentInfoProvinceName: initialValues.apartmentInfoProvinceName,
                attrValueVoList: initialValues.attrValueVoList,
                paymentTypeList: initialValues.paymentTypeList,
                leaseTermList: initialValues.leaseTermList,
                facilityInfoList: initialValues.facilityInfoList,
                labelInfoList: initialValues.labelInfoList,
                feeValueVoList: initialValues.feeValueVoList,
                roomId: initialValues.id,


                apartmentName: initialValues.apartmentName,
                description: initialValues.introduction,
                address: initialValues.addressDetail,
                phone: initialValues.phone,
                isRelease: initialValues.isRelease === 1 ? 'released' : 'withdrawn',
                facilities: initialValues.facilityInfoList.map(item => item.name),
                fees: (initialValues.feeValueVoList || []).map(item => `${item.feeKeyName}-${item.name}${item.unit}`),
                label: initialValues.labelInfoList.map(item => item.name)

            });
        }
    }, [initialValues, form]);



    const labelList = [
        {
            "id": 1,
            "createTime": "2023-49-19 02:49:17",
            "updateTime": null,
            "isDeleted": 0,
            "type": 1,
            "name": "近地铁"
        },
        {
            "id": 2,
            "createTime": "2023-49-19 02:49:23",
            "updateTime": null,
            "isDeleted": 0,
            "type": 1,
            "name": "近公交"
        },
        {
            "id": 3,
            "createTime": "2023-49-19 02:49:28",
            "updateTime": null,
            "isDeleted": 0,
            "type": 1,
            "name": "有电梯"
        },
        {
            "id": 4,
            "createTime": "2023-49-19 02:49:38",
            "updateTime": "2023-43-21 11:43:51",
            "isDeleted": 0,
            "type": 1,
            "name": "停车场"
        },
        {
            "id": 1000,
            "createTime": "2025-30-13 19:30:06",
            "updateTime": null,
            "isDeleted": 0,
            "type": 1,
            "name": "666"
        }
    ].map(item => ({
        label: item.name,
        value: item.name
    }))

    const facilityOptions = facilityList
        .filter(item => formType === 'apartment' ? item.type === 1 : item.type === 2) // Apartment
        .map(item => ({
            label: item.name,
            value: item.name
        }));

    const feeList = [
        {
            "id": 1,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "name": "停车费",
            "feeValueList": [
                {
                    "id": 3,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "400",
                    "unit": "元/月",
                    "feeKeyId": 1
                },
                {
                    "id": 2,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "300",
                    "unit": "元/月",
                    "feeKeyId": 1
                },
                {
                    "id": 1,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "200",
                    "unit": "元/月",
                    "feeKeyId": 1
                }
            ]
        },
        {
            "id": 2,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "name": "网费",
            "feeValueList": [
                {
                    "id": 7,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "500",
                    "unit": "元/年",
                    "feeKeyId": 2
                },
                {
                    "id": 6,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "1000",
                    "unit": "元/年",
                    "feeKeyId": 2
                },
                {
                    "id": 5,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "60",
                    "unit": "元/月",
                    "feeKeyId": 2
                },
                {
                    "id": 4,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "50",
                    "unit": "元/月",
                    "feeKeyId": 2
                }
            ]
        },
        {
            "id": 6,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "name": "电费",
            "feeValueList": [
                {
                    "id": 15,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "0.5",
                    "unit": "元/度",
                    "feeKeyId": 6
                },
                {
                    "id": 14,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "1",
                    "unit": "元/度",
                    "feeKeyId": 6
                },
                {
                    "id": 13,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "1.5",
                    "unit": "元/度",
                    "feeKeyId": 6
                }
            ]
        },
        {
            "id": 7,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "name": "水费",
            "feeValueList": [
                {
                    "id": 19,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "7",
                    "unit": "元/吨",
                    "feeKeyId": 7
                },
                {
                    "id": 18,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "8",
                    "unit": "元/吨",
                    "feeKeyId": 7
                },
                {
                    "id": 17,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "9",
                    "unit": "元/吨",
                    "feeKeyId": 7
                },
                {
                    "id": 16,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "10",
                    "unit": "元/吨",
                    "feeKeyId": 7
                }
            ]
        },
        {
            "id": 8,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "name": "取暖费",
            "feeValueList": [
                {
                    "id": 22,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "1500",
                    "unit": "元/年",
                    "feeKeyId": 8
                },
                {
                    "id": 21,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "1200",
                    "unit": "元/年",
                    "feeKeyId": 8
                },
                {
                    "id": 20,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "1000",
                    "unit": "元/年",
                    "feeKeyId": 8
                }
            ]
        }
    ].flatMap(record =>
        record.feeValueList.map(value => {
            const label = `${record.name}-${value.name}${value.unit}`;
            return {
                label,
                value: label,
            };
        })
    );

    return <Modal
        title={`Add a new ${formType}`}
        open={isModalOpen}
        onOk={() => setIsModalOpen(false)}
        onCancel={handleCancelInternal}
        okText="Submit"
        cancelText="Cancel"
        width={800}
    >
        {/* Save or Update Apartment form */}
        <Form form={form} layout='vertical' name='newApartmentForm'>
            {/* Apartment Name / Room Number */}
            {formType === 'apartment' ? (
                <Form.Item name='apartmentName' label='Apartment Name'>
                    <Input />
                </Form.Item>
            ) : null}
            {
                formType === 'room' ? (
                    <Form.Item name='roomNumber' label='Room Number'>
                        <Input />
                    </Form.Item>
                ) : null
            }

            {/* Rental (Room ONLY) */}
            {formType === 'room' ? (
                <Form.Item name='rental' label='Rental'>
                    <Input />
                </Form.Item>
            ) : null}


            {
                formType === 'apartment' ? (<Form.Item name='description' label='Description'>
                    <Input.TextArea />
                </Form.Item>) : null
            }

            <AreaSelector
            form={form}
            initialValues={initialValues}
             />

            {formType === 'apartment' ? (<Form.Item name='address' label='Address'>
                <Input />
            </Form.Item>) : null
            }
            {formType === 'apartment' ? (<Form.Item name='phone' label='Contact'>
                <Input />
            </Form.Item>) : null}


            <Form.Item name='isRelease' label='Release status'>
                <Radio.Group>
                    <Radio.Button value="released">Released</Radio.Button>
                    <Radio.Button value="withdrawn">Withdrawn</Radio.Button>
                </Radio.Group>
            </Form.Item>

            {
                formType === 'room' ? (<Form.Item name='attr' label='Room Attributes'>
                    <Select
                        mode="multiple"
                        placeholder="Please select"
                        options={facilityOptions}
                    />
                </Form.Item>) : null
            }

            <Form.Item name='facilities' label='Facilities'>
                <Select
                    mode="multiple"
                    placeholder="Please select"
                    options={facilityOptions}
                />
            </Form.Item>

            <Form.Item name='fees' label='Fees'>
                <Select
                    mode="multiple"
                    placeholder="Please select"
                    options={feeList}
                />
            </Form.Item>
            <Form.Item
                name='label'
                label='Label' >
                <Select
                    mode="multiple"
                    placeholder="Please select"
                    options={labelList}

                />
            </Form.Item>
            {
                formType === 'room' ? (<Form.Item
                    name='paymentType'
                    label='Payment Type' >
                    <Select
                        mode="multiple"
                        placeholder="Please select"
                        options={[
                            { label: 'Monthly', value: 'monthly' },
                            { label: 'Yearly', value: 'yearly' },
                        ]}
                    />
                </Form.Item>) : null
            }

        </Form>


    </Modal>

}

export default UpdateForm;