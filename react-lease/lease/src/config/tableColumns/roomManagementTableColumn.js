import React from 'react';
import { Button, Space, Tag } from 'antd';
export const columns = (handleEdit, handleDelete) => [
    {
        title: 'Room Number',
        dataIndex: 'roomNumber',
        key: 'roomNumber',
        align: 'center',
        render: text => <a>{text}</a>,
    },
    {
        title: 'Rental',
        dataIndex: 'rent',
        key: 'rent',
        align: 'center',
        render: text => <a>{text}</a>,
    },
    {
        title: 'Province',
        dataIndex: ['apartmentInfo', 'provinceName'],
        key: 'provinceName',
        align: 'center',
        render: text => <a>{text}</a>,
    },
    {
        title: 'City',
        dataIndex: ['apartmentInfo', 'cityName'],
        key: 'cityName',
        align: 'center',
        render: text => <a>{text}</a>,
    },
    {
        title: 'District',
        dataIndex: ['apartmentInfo', 'districtName'],
        key: 'districtName',
        align: 'center',
        render: text => <a>{text}</a>,
    },
    {
        title: 'Apartment Name',
        dataIndex: ['apartmentInfo', 'name'],
        key: 'cityName',
        align: 'center',
        render: text => <a>{text}</a>,
    },
    {
        title: 'Occupy Status',
        dataIndex: 'isCheckIn',
        key: 'isCheckIn',
        align: 'center',
        render: (_, { isCheckIn }) => {
            if (isCheckIn === false) {
                return <Tag color="green">Available</Tag>;
            }
            else {
                return <Tag color="red">Occupied</Tag>;
            }
        }
    },
    {
        title: 'Released',
        dataIndex: 'isRelease',
        key: 'isRelease',
        align: 'center',
        render: (_, { isRelease }) => {
            if (isRelease === 1) {
                return <Tag color="green">Yes</Tag>;
            }
            if (isRelease === 0) {
                return <Tag color="red">No</Tag>;
            }
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