import React from 'react';
import { useState } from 'react';
import { Form, Input, Select, Button, Row, Col, Table } from 'antd';
import { tableData } from '../../../config/tableColumns/leaseTermTable';
import { columns } from '../../../config/tableColumns/leaseTermTable';
import  EditLeaseModal  from '../../../components/Form/leaseTermForm';

const { Option } = Select;

const LeaseTerm = () => {

    const [editingRecord, setEditingRecord] = useState(null);
    const [isModalVisible, setIsModalVisible] = useState(false);
    const handleEdit = (record) => {
        setEditingRecord(record);  
        setIsModalVisible(true);   
    };

    const handleDelete = (record) => {
        console.log("Delete", record);
    };
    const [form] = Form.useForm();

    const onFinish = (values) => {
        console.log('Received values of form: ', values);
    };

    const onReset = () => {
        form.resetFields();
    };

    // 模拟省份、城市、区域数据
    const provinces = ['浙江省', '江苏省', '广东省'];
    const cities = {
        '浙江省': ['杭州市', '宁波市', '温州市'],
        '江苏省': ['南京市', '苏州市', '无锡市'],
        '广东省': ['广州市', '深圳市', '东莞市']
    };
    const areas = {
        '杭州市': ['西湖区', '上城区', '下城区'],
        '宁波市': ['海曙区', '江北区', '鄞州区'],
        // 其他城市区域...
    };

    const [selectedProvince, setSelectedProvince] = React.useState('');
    const [selectedCity, setSelectedCity] = React.useState('');

    const handleProvinceChange = (value) => {
        setSelectedProvince(value);
        setSelectedCity('');
        form.setFieldsValue({ city: '', area: '' });
    };

    const handleCityChange = (value) => {
        setSelectedCity(value);
        form.setFieldsValue({ area: '' });
    };

    // 模拟公寓数据
    const seals = ['公寓1', '公寓2', '公寓3'];

    return (
        <div>
            <Form
                form={form}
                name="myForm"
                onFinish={onFinish}
                layout="vertical"
                style={{ maxWidth: '800px', margin: '0 auto' }}
            >
                <Row gutter={[16, 8]}>
                    <Col span={8}>
                        <Form.Item
                            name="name"
                            label="姓名"
                        >
                            <Input placeholder="请输入姓名" />
                        </Form.Item>
                    </Col>
                    <Col span={8}>
                        <Form.Item
                            name="phone"
                            label="手机"
                            rules={[{ pattern: /^1[3-9]\d{9}$/, message: '请输入正确的手机号' }]}
                        >
                            <Input placeholder="请输入手机号" />
                        </Form.Item>
                    </Col>
                    <Col span={8}>
                        <Form.Item
                            name="room"
                            label="房间"
                        >
                            <Input placeholder="请输入房间号" />
                        </Form.Item>
                    </Col>
                </Row>

                <Row gutter={[16, 8]}>
                    <Col span={8}>
                        <Form.Item
                            name="province"
                            label="省份"
                        >
                            <Select
                                placeholder="请选择省份"
                                onChange={handleProvinceChange}
                                allowClear
                            >
                                {provinces.map(province => (
                                    <Option key={province} value={province}>{province}</Option>
                                ))}
                            </Select>
                        </Form.Item>
                    </Col>
                    <Col span={8}>
                        <Form.Item
                            name="city"
                            label="城市"
                        >
                            <Select
                                placeholder="请选择城市"
                                onChange={handleCityChange}
                                disabled={!selectedProvince}
                                allowClear
                            >
                                {selectedProvince && cities[selectedProvince]?.map(city => (
                                    <Option key={city} value={city}>{city}</Option>
                                ))}
                            </Select>
                        </Form.Item>
                    </Col>
                    <Col span={8}>
                        <Form.Item
                            name="area"
                            label="区域"
                        >
                            <Select
                                placeholder="请选择区域"
                                disabled={!selectedCity}
                                allowClear
                            >
                                {selectedCity && areas[selectedCity]?.map(area => (
                                    <Option key={area} value={area}>{area}</Option>
                                ))}
                            </Select>
                        </Form.Item>
                    </Col>
                </Row>

                <Row gutter={[16, 10]}>
                    <Col span={8}>
                        <Form.Item
                            name="seal"
                            label="公章"
                        >
                            <Select placeholder="请选择公章" allowClear>
                                {seals.map(seal => (
                                    <Option key={seal} value={seal}>{seal}</Option>
                                ))}
                            </Select>
                        </Form.Item>
                    </Col>
                </Row>

                <Row gutter={[16, 10]} justify="center" style={{ marginTop: '20px' }}>
                    <Col>
                        <Button type="primary" htmlType="submit">
                            搜索
                        </Button>
                    </Col>
                    <Col>
                        <Button htmlType="button" onClick={onReset}>
                            重置
                        </Button>
                    </Col>
                    <Col>
                        <Button type="dashed">
                            合并
                        </Button>
                    </Col>
                </Row>
            </Form>
            <Table
                dataSource={tableData}
                columns={columns(handleEdit, handleDelete)}
            />
            <EditLeaseModal
                visible={isModalVisible}
                onCancel={() => setIsModalVisible(false)}
                onOk={(updatedData) => {
                    console.log("提交数据：", updatedData);
                    setIsModalVisible(false);
                }}
                record={editingRecord}
            />


        </div>
    );
}

export default LeaseTerm;