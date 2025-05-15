import React from 'react';
import { Button, Divider } from 'antd';
import AttributeDisplay from '../../../components/attributeDisplay';
import { roomAttributes, labels, facilities } from '../../../mock';
import { useState, useEffect } from 'react';
import { Form, Input, Modal, Select } from 'antd';



const Attributes = () => {
    const [formType, setFormType] = useState(''); // 'editValue', 'addValue', 'addType'
    const [visible, setVisible] = useState(false);
    const [mode, setMode] = useState("add"); // 'add' OR 'edit'
    const [formTitle, setFormTitle] = useState("");
    const [form] = Form.useForm();
    const [initialValues, setInitialValues] = useState({});

    useEffect(() => {
        if (visible) {
            form.setFieldsValue(initialValues);
        }
    }, [initialValues, visible]);


    const handleAddValue = (id, itemName) => {
        setFormTitle(`新增 ${itemName} 属性`);
        setMode('add');
        setFormType('addValue');
        setInitialValues({ parentId: id }); 
        setVisible(true);
    };

    const handleEditValue = (value) => {
        setFormTitle('编辑属性值');
        setMode('edit');
        setFormType('editValue');
        setInitialValues(value);
        setVisible(true);
    };

    const handleAddType = () => {
        setFormTitle('新增属性类型');
        setMode('add');
        setFormType('addType');
        setInitialValues({});
        setVisible(true);
    };



    function groupList(data, attributeType) {
        const grouped = {};
        let labelTypeRoom = "";
        let labelTypeApartment = "";
        if (attributeType === "labels") {
            labelTypeRoom = "房间标签";
            labelTypeApartment = "公寓标签";
        } else if (attributeType === "facilities") {
            labelTypeRoom = "房间配套";
            labelTypeApartment = "公寓配套";
        }


        data.forEach((item) => {
            const type = item.type;
            if (!grouped[type]) {
                grouped[type] = {
                    id: type,
                    name: type === 1 ? labelTypeApartment : labelTypeRoom,
                    attrValueList: []
                };
            }
            grouped[type].attrValueList.push({
                id: item.id,
                name: item.name
            });
        });

        return { data: Object.values(grouped) };
    }

    const labelsGrouped = groupList(labels.data, "labels");
    const facilitiesGrouped = groupList(facilities, "facilities");

    const infoStyle = {
        margin: 10,
        borderRadius: 8,
        overflow: 'hidden',
        width: 'calc(100% - 64px)',
        maxWidth: 'calc(100% - 32px)',
        padding: 16,
        border: '1px solid rgb(219, 214, 214)',
    }

    return (

        <div>
            {/* Facilities */}
            {
                <div style={infoStyle}>
                    <h1>{"Labels Info"}</h1>
                    <Divider />
                    <AttributeDisplay
                        contentValues={labelsGrouped}
                        handleEdit={handleEditValue}
                        handleAdd={handleAddValue}
                    />

                </div>
            }
            {/* Room info */}
            {

                <div style={infoStyle}>
                    <h1>{"Room Info"}</h1>
                    <Divider />
                    <AttributeDisplay
                        contentValues={roomAttributes}
                        handleEdit={handleEditValue}
                        handleAdd={handleAddValue}
                    />
                    <Button style={{ margin: 16 }} type="primary"
                        onClick={() => handleAddType()}
                    >
                        Add Room Attributes
                    </Button>
                </div>
            }
            {/* Facilities */}
            {
                <div style={infoStyle}>
                    <h1>{"Facilities Info"}</h1>
                    <Divider />
                    <AttributeDisplay
                        contentValues={facilitiesGrouped}
                        handleEdit={handleEditValue}
                        handleAdd={handleAddValue}
                    />

                </div>
            }

            <Modal
                visible={visible}
                title={formTitle}
                onCancel={() => setVisible(false)}
                onOk={() => form.submit()}
                destroyOnClose={true}
            >
                <Form
                    form={form}
                    initialValues={initialValues}
                    onFinish={(values) => {
                        if (formType === 'addValue') {
                            // 发送新增属性值的请求
                        } else if (formType === 'editValue') {
                            // 发送更新属性值的请求
                        } else if (formType === 'addType') {
                            // 发送新增属性类型的请求
                        }
                        setVisible(false);
                    }}
                >
                    {formType === 'addType' ? (
                        <Form.Item
                            name="typeName"
                            label="属性类型名称"
                            rules={[{ required: true, message: '请输入属性类型名称' }]}
                        >
                            <Input />
                        </Form.Item>
                    ) : (
                        <>
                            <Form.Item
                                name="name"
                                label="属性值名称"
                                rules={[{ required: true, message: '请输入属性值名称' }]}
                            >
                                <Input />
                            </Form.Item>
                            <Form.Item name="parentId" hidden>
                                <Input />
                            </Form.Item>
                        </>
                    )}
                </Form>
            </Modal>


        </div>
    )

};

export default Attributes;
