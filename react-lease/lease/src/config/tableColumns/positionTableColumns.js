import React from 'react';
import { Button, Space, Switch } from 'antd';

export const records = [
    {
        "id": 1,
        "createTime": "2023-01-10 11:01:56",
        "updateTime": "2023-01-10 19:01:57",
        "isDeleted": 0,
        "postCode": "regional manager",
        "name": "区域经理",
        "description": "区域经理",
        "status": 1
    },
    {
        "id": 6,
        "createTime": "2023-04-10 11:04:00",
        "updateTime": "2023-04-10 19:04:01",
        "isDeleted": 0,
        "postCode": "general manager",
        "name": "总经理",
        "description": "总经理",
        "status": 1
    },
    {
        "id": 7,
        "createTime": "2023-03-10 11:03:55",
        "updateTime": "2023-03-10 19:03:56",
        "isDeleted": 0,
        "postCode": "apartment manager",
        "name": "店长",
        "description": "公寓店长",
        "status": 1
    }
]

export const columns = [

    {
        title: 'Index',
        dataIndex: 'id',
        key: 'id',
        align: 'center',
        render: (_, record) => record.id || 'N/A',
    },
    {
        title: 'Name',
        dataIndex: 'name',
        key: 'name',
        align: 'center',
        render: (_, record) => record.name || 'N/A',
    },
    {
        title: 'Code',
        dataIndex: 'postCode',
        key: 'postCode',
        align: 'center',
        render: (_, record) => record.postCode || record.apartmentInfo?.postCode || 'N/A',
    },
    {
        title: 'Description',
        dataIndex: 'description',
        key: 'description',
        align: 'center',
        render: (_, record) => record.description || 'N/A',
    },
    {
        title: 'Status',
        dataIndex: 'status',
        key: 'status',
        align: 'center',
        render: (_, record) => (
            <Switch
                checked={record.status === 1}
        
            />
        ),
    },

    {
        title: 'Action',
        key: 'action',
        align: 'center',
        render: (_, record) => (
            <Space size="middle">
                <Button type="primary" onClick={() => console.log('Edit')}>Edit</Button>
                <Button type="primary" danger onClick={() => console.log('Delete')}>Delete</Button>
            </Space>
        ),
    }
]