import { Button, Modal, Table, Form, Input, Space, Switch } from "antd";
import { records, columns as baseColumns } from "../../../config/tableColumns/positionTableColumns";
import { useState } from "react";


const Position = () => {
    const [isModalVisible, setIsModalVisible] = useState(false);
    const [editingRecord, setEditingRecord] = useState(null);
    const [form] = Form.useForm();

    const handleEdit = (record) => {
        setEditingRecord(record);
        form.setFieldsValue({
            ...record,
            status: record.status === 1,
        });
        setIsModalVisible(true);
    };

    const handleAdd = () => {
        setIsModalVisible(true);
        
    }

    // Bond data to button
    const columns = baseColumns.map((col) => {
        if (col.key === "action") {
            return {
                ...col,
                render: (_, record) => (
                    <Space size="middle">
                        <Button type="primary" onClick={() => handleEdit(record)}>Edit</Button>
                        <Button type="primary" danger onClick={() => console.log("Delete")}>Delete</Button>
                    </Space>
                ),
            };
        }
        return col;
    });

    // 提交表單資料
    const handleOk = () => {
        form.validateFields().then((values) => {
            const updatedData = {
                ...editingRecord,
                ...values,
                status: values.status ? 1 : 0,
            };
           // Update the record in the data source
           // -- This is a placeholder for the actual update logic
            setIsModalVisible(false);
        });
    };



    return (
        <div>
            <Button type="primary"
                style={{ marginBottom: 16 }}
                onClick={() => handleAdd()}
            >+ Add</Button>

            <Table
                dataSource={records}
                columns={columns}
            />
            <Modal
                title="Edit"
                open={isModalVisible}
                onOk={handleOk}
                onCancel={() => setIsModalVisible(false)}
            >
                <Form form={form} layout="vertical">
                    <Form.Item name="name" label="岗位名称" rules={[{ required: true, message: "请输入岗位名称" }]}>
                        <Input />
                    </Form.Item>
                    <Form.Item name="postCode" label="岗位编码" rules={[{ required: true, message: "请输入岗位编码" }]}>
                        <Input />
                    </Form.Item>
                    <Form.Item name="description" label="岗位描述" rules={[{ required: true, message: "请输入岗位描述" }]}>
                        <Input.TextArea />
                    </Form.Item>
                    <Form.Item name="status" label="状态" valuePropName="checked">
                        <Switch checkedChildren="正常" unCheckedChildren="停用" />
                    </Form.Item>
                </Form>
            </Modal>

        </div>
    );
}

export default Position;