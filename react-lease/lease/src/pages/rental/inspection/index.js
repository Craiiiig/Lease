import React from 'react';
import { Button, Form, Input, Select, Table } from 'antd';
import { columns, tableData } from '../../../config/tableColumns/inspectionTable';
import { useState, useEffect } from 'react';
import axios from 'axios';

const Inspection = () => {

    useEffect(() => {
       
        fetchTableData(pagination.current, pagination.pageSize);
        console.log(tableData);

      }, []);
      

    const [tableData, setTableData] = useState([]);
    const [pagination, setPagination] = useState({
        current: 1,
        pageSize: 2,
        total: 0,
    });

    const fetchTableData = async (current, pageSize, queryVo = {}) => {
        setLoading(true);
        try {
            const res = await axios.get('http://localhost:8080/admin/appointment/page', {
                params: {
                    current,
                    size: pageSize,
                    ...queryVo,
                }
            });

            const result = res.data.data;

            setTableData(result.records); // IPage 的 records 是資料陣列
            setPagination({
                current: result.current,
                pageSize: result.size,
                total: result.total,
            });
        } catch (error) {
            console.error('取得資料失敗', error);
        } finally {
            setLoading(false);
        }
    };

    const handleTableChange = (pagination) => {
        fetchTableData(pagination.current, pagination.pageSize);
      };


    const [loading, setLoading] = useState(false);
    return (
        <div style={{ padding: '24px' }}>
            <Form
                layout="horizontal"
                labelCol={{ span: 8 }}
                wrapperCol={{ span: 14 }}
                style={{ maxWidth: 600 }}
                onFinish={(values) => console.log('Success:', values)}
                onFinishFailed={(errorInfo) => console.log('Failed:', errorInfo)}
            >
                <div
                    style={{ display: 'flex', flexDirection: 'row', justifyContent: 'space-between' }}
                >
                    <div>
                        <Form.Item
                            label="Name"
                            name="name"
                        >
                            <Input placeholder="Enter name" />
                        </Form.Item>

                        <Form.Item
                            label="Contact"
                            name="contact"
                        >
                            <Input placeholder="Enter contact" />
                        </Form.Item>

                        <Form.Item wrapperCol={{ offset: 8, span: 20 }}>
                            <Button type="primary" htmlType="submit">
                                Search
                            </Button>
                        </Form.Item>
                    </div>
                    <div>

                        <Form.Item
                            label="Province"
                            name="province"
                        >

                            <Select placeholder="Select a province">
                                <Select.Option value="Guangdong">Guangdong</Select.Option>
                                <Select.Option value="Taiwan">Taiwan</Select.Option>

                            </Select>
                        </Form.Item>

                        <Form.Item
                            label="City"
                            name="city"
                        >

                            <Select placeholder="Select a City">
                                <Select.Option value="Guangdong">Guangzhou</Select.Option>
                                <Select.Option value="Taiwan">Taipei</Select.Option>

                            </Select>
                        </Form.Item>

                        <Form.Item
                            label="District"
                            name="district"
                        >

                            <Select placeholder="Select a District">
                                <Select.Option value="Huangpu">Huangpu</Select.Option>
                                <Select.Option value="Xinyi">Xinyi</Select.Option>
                            </Select>
                        </Form.Item>
                    </div>
                </div>
            </Form>
            <Table
                columns={columns}
                dataSource={tableData}
                loading={loading}
                rowKey="id" 
                pagination={{
                    current: pagination.current,
                    pageSize: pagination.pageSize,
                    total: pagination.total,
                    showSizeChanger: true,
                    pageSizeOptions: ['2', '1', '4']
                }}
                onChange={handleTableChange}
            />
        </div>
    );
};

export default Inspection;
