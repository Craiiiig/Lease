import React, { useState, useEffect } from 'react';
import { Form, Select, Row, Col } from 'antd';
import { provinceList, cityList, districtList } from '../../mock';

const { Option } = Select;

const AreaSelector = ({ initialValues, form }) => {
    const [cities, setCities] = useState([]);
    const [districts, setDistricts] = useState([]);
    const [selectedProvinceId, setSelectedProvinceId] = useState(initialValues?.provinceId || null);

    const [selectedCityId, setSelectedCityId] = useState(initialValues?.cityId || null);
    const [selectedDistrictId, setSelectedDistrictId] = useState(initialValues?.districtId || null);
    const [selectedProvinceName, setSelectedProvinceName] = useState(initialValues?.provinceName || null);
    const [selectedCityName, setSelectedCityName] = useState(initialValues?.cityName || null);
    const [selectedDistrictName, setSelectedDistrictName] = useState(initialValues?.districtName || null);
    

    // 初始化默认省份和城市（可选）
    useEffect(() => {
        const defaultProvinceId = provinceList[0]?.id;
        handleProvinceChange(defaultProvinceId);
    }, []);

    // 处理选择省份
    const handleProvinceChange = (provinceId) => {
        // 清除已选值
        form.setFieldsValue({ city: undefined, district: undefined });

        const filteredCities = cityList.filter(city => city.provinceId === provinceId);
        const firstCityId = filteredCities[0]?.id;

        setSelectedProvinceId(provinceId);
        setCities(filteredCities);

        if (firstCityId) {
            setSelectedCityId(firstCityId);
            form.setFieldsValue({ city: firstCityId }); // 设置城市默认值（可选）
            const filteredDistricts = districtList.filter(d => d.cityId === firstCityId);
            setDistricts(filteredDistricts);
        } else {
            setSelectedCityId(null);
            setDistricts([]);
        }
    };


    // 处理选择城市
    const handleCityChange = (cityId) => {
        setSelectedCityId(cityId);
        const filteredDistricts = districtList.filter(district => district.cityId === cityId);
        setDistricts(filteredDistricts);
    };

    return (
        <Form.Item label='Location'>
            <Row gutter={16}>
                {/* 省份 */}
                <Col span={8}>
                    <Form.Item name="province" noStyle>
                        <Select
                            value={selectedProvinceName}
                            onChange={handleProvinceChange}
                            placeholder="选择省份"
                        >
                            {provinceList.map((province) => (
                                <Option key={province.id} value={province.id}>{province.name}</Option>
                            ))}
                        </Select>
                    </Form.Item>
                </Col>

                {/* 城市 */}
                <Col span={8}>
                    <Form.Item name="city" noStyle>
                        <Select
                            value={selectedCityId}
                            onChange={handleCityChange}
                            placeholder="选择城市"
                        >
                            {cities.map((city) => (
                                <Option key={city.id} value={city.id}>{city.name}</Option>
                            ))}
                        </Select>
                    </Form.Item>
                </Col>

                {/* 区县 */}
                <Col span={8}>
                    <Form.Item name="district" noStyle>
                        <Select placeholder="选择区">
                            {districts.map((district) => (
                                <Option key={district.id} value={district.id}>{district.name}</Option>
                            ))}
                        </Select>
                    </Form.Item>
                </Col>
            </Row>
        </Form.Item>
    );
};

export default AreaSelector;
