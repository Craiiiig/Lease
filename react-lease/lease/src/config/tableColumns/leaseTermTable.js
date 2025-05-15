
import { Button, Space, Tag } from 'antd';
const records = [
    {
        "id": 1,
        "createTime": "2023-36-21 17:36:08",
        "updateTime": "2023-03-14 17:03:03",
        "isDeleted": 0,
        "phone": "13888888888",
        "name": "张三",
        "identificationNumber": "13241413243241324",
        "apartmentId": 9,
        "roomId": 3,
        "leaseStartDate": "2020-12-29",
        "leaseEndDate": "2019-12-30",
        "leaseTermId": 6,
        "rent": 2500.00,
        "deposit": 0.00,
        "paymentTypeId": 6,
        "status": 4,
        "sourceType": 1,
        "additionalInfo": "无",
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
        },
        "roomInfo": {
            "id": 3,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "roomNumber": "102",
            "rent": 2500.00,
            "apartmentId": 9,
            "isRelease": null
        },
        "paymentType": {
            "id": 6,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "name": "Monthly",
            "payMonthCount": "1",
            "additionalInfo": "无"
        },
        "leaseTerm": {
            "id": 6,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "monthCount": 12,
            "unit": "月"
        }
    }
]

export const tableData = records.map(item => ({
    key: item.id,
    ...item
}));


export const columns = (handleEdit, handleDelete) => [
    {
        title: 'Name',
        dataIndex: 'name',
        key: 'name',
        align: 'center',
        render: (_, record) => record.name || 'N/A',
    },
    {
        title: 'Contact',
        dataIndex: 'phone',
        key: 'phone',
        align: 'center',
        render: (_, record) => record.phone || record.apartmentInfo?.phone || 'N/A',
    },
    {
        title: 'Room',
        dataIndex: ['roomInfo', 'roomNumber'],
        key: 'room',
        align: 'center',
        render: (_, record) => record.roomInfo?.roomNumber || 'N/A',
    },
    {
        title: 'Apartment',
        dataIndex: ['apartmentInfo', 'name'],
        key: 'apartment',
        align: 'center',
        render: (_, record) => record.apartmentInfo?.name || 'N/A',
    },
    {
        title: 'Province',
        dataIndex: ['apartmentInfo', 'provinceName'],
        key: 'province',
        align: 'center',
        render: (_, record) => record.apartmentInfo?.provinceName || 'N/A',
    },
    {
        title: 'City',
        dataIndex: ['apartmentInfo', 'cityName'],
        key: 'city',
        align: 'center',
        render: (_, record) => record.apartmentInfo?.cityName || 'N/A',
    },
    {
        title: 'District',
        dataIndex: ['apartmentInfo', 'districtName'],
        key: 'district',
        align: 'center',
        render: (_, record) => record.apartmentInfo?.districtName || 'N/A',
    },
    {
        title: 'Occupy Status',
        dataIndex: 'status',
        key: 'status',
        align: 'center',
        render: (_, record) => {
            const status = record.status || 'available';
            return (
                <Tag color={status === 'available' ? 'green' : 'red'}>
                    {status === 'available' ? 'Available' : 'Full'}
                </Tag>
            );
        }
    },
    {
        title: 'Released',
        dataIndex: ['roomInfo', 'isRelease'],
        key: 'released',
        align: 'center',
        render: (_, record) => {
            const released = record.roomInfo?.isRelease === null ? 'no' : 'yes';
            return (
                <Tag color={released === 'yes' ? 'green' : 'red'}>
                    {released === 'yes' ? 'Yes' : 'No'}
                </Tag>
            );
        }
    },
    {
        title: 'Action',
        key: 'action',
        align: 'center',
        render: (_, record) => (
            <Space size="middle">
                <Button type="primary" onClick={() => handleEdit(record)}>Edit</Button>
                <Button type="primary" danger onClick={() => handleDelete(record)}>Delete</Button>
            </Space>
        ),
    }
];

