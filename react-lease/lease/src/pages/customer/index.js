import React, { useState } from 'react';
import { Button, Form, Input, Radio, Tooltip, Flex, Divider, Table } from 'antd';
import { SearchOutlined } from '@ant-design/icons';
import { column } from '../../config/tableColumns/customerTableColumn';
import { customerList } from '../../mock'
const Customer = () => {
    const [form] = Form.useForm();

    return (
        <div>
            <Form
                layout="inline"
                form={form}
            >
                <Form.Item
                    label='Contact'
                    name='phone'
                >
                    <Input />
                </Form.Item>
                <Form.Item
                    label='Account Status'
                    name='status'
                >
                    <Radio.Group>
                        <Radio value="1">Active</Radio>
                        <Radio value="0">Inactive</Radio>
                    </Radio.Group>
                    <Divider
                        type="vertical"
                        size="large"
                        style={{ height: '20px', borderColor: 'black' }}
                    />
                </Form.Item>
                <Form.Item>
                    <Flex wrap gap="small">
                        <Tooltip title="search">
                            <Button shape="circle" icon={<SearchOutlined />} />
                        </Tooltip>
                        <Button type='primary' 
                        onClick={() => form.resetFields()}
                        icon={<SearchOutlined />}>Reset</Button>
                    </Flex>
                </Form.Item>
            </Form>

            <Divider />

            <Table
                columns={column}
                dataSource={customerList}
                pagination={true}
            />


        </div>
    );
}
export default Customer;