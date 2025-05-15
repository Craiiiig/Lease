import { useState } from "react";
import { Button, Form, Input, Space, Table, Switch } from "antd";
import { records, columns as baseColumn } from "../../../config/tableColumns/userTableColumns";
const User = () => {
    const [form] = Form.useForm();
    const [formLayout, setFormLayout] = useState('inline');
    const [checked, setChecked] = useState(true);

    const column = baseColumn.map((item) => {
        if (item.dataIndex === 'status') {
            return {
                ...item,
                render: (_, record) => (
                    <Switch
                        checked={record.status === 1 && checked}
                        onChange={() => {
                            setChecked(!checked);
                        }}
                    />
                )
            }

        }
        if (item.dataIndex === 'action') {
            return {
                ...item,
                render: (_, record) => (
                    <Space size="middle">
                        <Button type="primary" onClick={() => console.log(record)}>Edit</Button>
                        <Button type="primary" danger onClick={() => console.log("Delete")}>Delete</Button>
                    </Space>
                )

            }

        }
        return item;
    })

    return (
        <div>
            <Form
                layout={formLayout}
                form={form}
                initialValues={{ layout: formLayout }}

                style={{ maxWidth: formLayout === 'inline' ? 'none' : 600 }}
            >

                <Form.Item label="Name" name="name">
                    <Input placeholder="Name..."
                        style={{ width: 200 }}
                    />
                </Form.Item>
                <Form.Item label="Contact" name="contact">
                    <Input placeholder="Contact..." style={{ width: 200 }} />
                </Form.Item>
                <Form.Item>
                    <Button type="primary">Search</Button>
                </Form.Item>
                <Form.Item>
                    <Button type="primary"
                        onClick={() => form.resetFields()}
                    >Reset</Button>
                </Form.Item>
            </Form>
            <Table
                dataSource={records}
                columns={column}
            />
        </div>
    );
}
export default User;