import { Form, Select, Row, Col, Button } from 'antd';
const LocationFilterForm = ({ componentSize, onFormLayoutChange, showModal, parentClassName }) => {
    return (
        <Form
            layout="vertical"
            initialValues={{ size: componentSize }}
            onValuesChange={onFormLayoutChange}
            size={componentSize}
            style={{ maxWidth: 1000 }}
        >
            <Row gutter={16}>
                <Col span={8}>
                    <Form.Item label="Province" name="province">
                        <Select placeholder="Select a province">
                            <Select.Option value="guangdong">Guangdong</Select.Option>
                        </Select>
                    </Form.Item>
                </Col>
                <Col span={8}>
                    <Form.Item label="City" name="city">
                        <Select placeholder="Select a city">
                            <Select.Option value="guangzhou">Guangzhou</Select.Option>
                        </Select>
                    </Form.Item>
                </Col>
                <Col span={8}>
                    <Form.Item label="District" name="district">
                        <Select placeholder="Select a district">
                            <Select.Option value="huangpu">Huangpu</Select.Option>
                        </Select>
                    </Form.Item>
                </Col>

            </Row>
            <Row gutter={16}>
                <Col span={3}>
                    <Form.Item label=" ">
                        <Button type="primary" htmlType="submit">
                            Search
                        </Button>
                    </Form.Item>
                </Col>
                <Col span={3}>
                    <Form.Item label=" ">
                        <Button type="primary"
                            onClick={showModal}
                        >
                            {parentClassName === "ApartmentManagement" ? "Add a new apartment" : "Add a new room"}
                        </Button>
                    </Form.Item>
                </Col>
            </Row>
        </Form>
    )
}

export default LocationFilterForm;