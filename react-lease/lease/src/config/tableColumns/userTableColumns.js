import { Button, Switch } from "antd"
import Title from "antd/es/skeleton/Title"

export const records = [
    {
        "id": 1,
        "createTime": null,
        "updateTime": null,
        "isDeleted": null,
        "username": "admin",
        "password": null,
        "name": "管理员",
        "type": 0,
        "phone": "18888888888",
        "avatarUrl": null,
        "additionalInfo": null,
        "postId": 6,
        "status": 1
    },
    {
        "id": 2,
        "createTime": null,
        "updateTime": null,
        "isDeleted": null,
        "username": "user",
        "password": null,
        "name": "用户",
        "type": 1,
        "phone": "13666666666",
        "avatarUrl": null,
        "additionalInfo": null,
        "postId": 7,
        "status": 1
    }
]

export const columns = [
    {
        title: 'id', 
        dataIndex: 'id',
        key: 'id',
        align: 'center',
        render: (_, record) => record.id || 'N/A'
    }, 
    {
        title: 'Name', 
        dataIndex: 'name',
        key: 'name',
        align: 'center',
        render: (_, record) => record.name || 'N/A'
    }, 
    {title: 'Contact', 
        dataIndex: 'phone',
        key: 'phone',
        align: 'center',
        render: (_, record) => record.phone || 'N/A'
    }, 
    {
        title: 'Type', 
        dataIndex: 'type',
        key: 'type',
        render: (_, record) => {
            if (record.type === 0) {
                return 'Admin'
            } else if (record.type === 1) {
                return 'Common User'
            } 
        }
    }, 
    {
        title: 'Status', 
        dataIndex: 'status',
        key: 'status',
        render: (_, record) => {
            <Switch
                checked={record.status === 1}
            />
        }
    },
    {
        title: 'Action',
        key: 'action',
        align: 'center',
        dataIndex: 'action',
        render: (_, record) => (
        'NA'
        ),
    },

]