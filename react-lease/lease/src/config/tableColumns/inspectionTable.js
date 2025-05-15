import React from 'react';
import { Tag, Space, Button } from 'antd';

export const columns = [
    {
        title: 'Name',
        dataIndex: 'name',
        key: 'name',
        render: text => <a>{text}</a>,
    },
    {
        title: 'Contact',
        dataIndex: 'phone',
        key: 'contact',
    },
    {
        title: 'Province',
        dataIndex: ['apartmentInfo', 'provinceName'],
        key: 'province',
    },
    {
        title: 'City',
        dataIndex: ['apartmentInfo', 'cityName'],
        key: 'city',
    },
    {
        title: 'District',
        dataIndex: ['apartmentInfo', 'districtName'],
        key: 'district',
    },
    {
        title: 'Apartment',
        dataIndex: ['apartmentInfo', 'name'],
        key: 'apartment',
    },
    {
        title: 'Time',
        dataIndex: 'appointmentTime',
        key: 'time',
    },
    {
        title: 'Status',
        key: 'status',
        dataIndex: 'appointmentStatus',
        render: status => {
            let color = '';
            let text = '';
            switch (status) {
                case 1:
                    color = 'blue';
                    text = 'PENDING';
                    break;
                case 2:
                    color = 'red';
                    text = 'CANCELLED';
                    break;
                case 3:
                    color = 'green';
                    text = 'INSPECTED';
                    break;
                default:
                    color = 'gray';
                    text = 'UNKNOWN';
            }
            return <Tag color={color}>{text}</Tag>;
        },
    },
    {
        title: 'Action',
        key: 'action',
        render: (_, record) => (
            <Space size="middle">
                {record.appointmentStatus === 1 && (
                    <Button type="primary">Inspect</Button>
                )}
                {record.appointmentStatus === 2 && (
                    <Button disabled type="default" style={{ color: 'gray', borderColor: 'lightgray' }}>
                        Cancelled
                    </Button>
                )}
                {record.appointmentStatus === 3 && (
                    <Button type="default">Inspected</Button>
                )}
            </Space>
        ),
    }
    ,
];

const records = [
    {
        "id": 1,
        "createTime": null,
        "updateTime": null,
        "isDeleted": null,
        "userId": 1,
        "name": "张三",
        "phone": "13888888888",
        "apartmentId": 9,
        "appointmentTime": "2023-01-14 11:01:01",
        "additionalInfo": "无",
        "appointmentStatus": 3,
        "apartmentInfo": {
            "id": 9,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "name": "温都水城社区",
            "introduction": null,
            "districtId": 110114,
            "districtName": "昌平区",
            "cityId": 1101,
            "cityName": "市辖区",
            "provinceId": 11,
            "provinceName": "北京市",
            "addressDetail": null,
            "latitude": null,
            "longitude": null,
            "phone": "13888888888",
            "isRelease": null
        }
    },
    {
        "id": 2,
        "createTime": null,
        "updateTime": null,
        "isDeleted": null,
        "userId": 2,
        "name": "李四",
        "phone": "13666666666",
        "apartmentId": 9,
        "appointmentTime": "2023-01-14 11:01:01",
        "additionalInfo": "无",
        "appointmentStatus": 3,
        "apartmentInfo": {
            "id": 9,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "name": "温都水城社区",
            "introduction": null,
            "districtId": 110114,
            "districtName": "昌平区",
            "cityId": 1101,
            "cityName": "市辖区",
            "provinceId": 11,
            "provinceName": "北京市",
            "addressDetail": null,
            "latitude": null,
            "longitude": null,
            "phone": "13666666666",
            "isRelease": null
        }
    },
    {
        "id": 10,
        "createTime": null,
        "updateTime": null,
        "isDeleted": null,
        "userId": 7,
        "name": "张三",
        "phone": "13888888888",
        "apartmentId": 9,
        "appointmentTime": "2023-40-14 17:40:00",
        "additionalInfo": "无",
        "appointmentStatus": 3,
        "apartmentInfo": {
            "id": 9,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "name": "温都水城社区",
            "introduction": null,
            "districtId": 110114,
            "districtName": "昌平区",
            "cityId": 1101,
            "cityName": "市辖区",
            "provinceId": 11,
            "provinceName": "北京市",
            "addressDetail": null,
            "latitude": null,
            "longitude": null,
            "phone": "13888888888",
            "isRelease": null
        }
    },
    {
        "id": 11,
        "createTime": null,
        "updateTime": null,
        "isDeleted": null,
        "userId": 7,
        "name": "张三",
        "phone": "13888888888",
        "apartmentId": 10,
        "appointmentTime": "2023-45-14 16:45:20",
        "additionalInfo": "",
        "appointmentStatus": 3,
        "apartmentInfo": {
            "id": 10,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "name": "回龙观社区",
            "introduction": null,
            "districtId": 110114,
            "districtName": "昌平区",
            "cityId": 1101,
            "cityName": "市辖区",
            "provinceId": 11,
            "provinceName": "北京市",
            "addressDetail": null,
            "latitude": null,
            "longitude": null,
            "phone": "13888888888",
            "isRelease": null
        }
    }
]
export const tableData = records.map(item => ({
    key: item.id,
    ...item
}));