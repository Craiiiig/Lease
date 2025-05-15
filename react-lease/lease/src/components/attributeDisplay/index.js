import React, { useEffect } from 'react';
import { Layout, Dropdown, Button, Tag } from 'antd';
const { Sider, Content } = Layout;

const contentStyle = {
    overflow: 'hidden',
    borderRadius: 16,
    textAlign: 'center',
    minHeight: 60,
    lineHeight: '60px',
    color: '#000000',
    backgroundColor: '#efefef',
    display: 'flex',
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'flex-start',
    padding: '10px 15px'
};

const buttonStyle = {
    borderRadius: 50,
    height: 40,
    width: 40,
    color: '#000000',
    marginLeft: 8,
}

const siderStyle = {
    width: "15%",
    textAlign: 'center',
    lineHeight: '60px',
    color: '#000000',
    backgroundColor: '#fff',
    borderTopLeftRadius: 8,
    borderBottomLeftRadius: 8,
    overflow: 'hidden'
};


const layoutStyle = {
    backgroundColor: '#fff',
    margin: 10,
    borderRadius: 8,
    overflow: 'hidden',
    width: 'calc(100% - 8px)',
    maxWidth: 'calc(100% - 8px)',
};

const AttributeDisplay = ({ contentValues, handleEdit, handleAdd }) => {

    return (
        <div>
            {contentValues.data.map((item) => (
                <Layout key={item.id} style={layoutStyle}>
                    <Sider style={siderStyle}>
                        {item.name}
                    </Sider>
                    <Content style={contentStyle}>
                        {item.attrValueList.map((value) => (
                            <Dropdown
                                key={value.id}
                                menu={{
                                    items: [
                                        {
                                            key: 'edit',
                                            label: (
                                                <span onClick={() => handleEdit(value)}>
                                                    Edit
                                                </span>
                                            ),
                                        },
                                        // 其他菜单项
                                    ],
                                }}
                            >
                                <Tag color="blue" style={{ margin: 4 }}>{value.name}</Tag>
                            </Dropdown>
                        ))}
                        <Button style={buttonStyle}
                            onClick={() => handleAdd(item.id, item.name)}
                        >+</Button>
                    </Content>
                </Layout>
            ))}
        </div>
    );
};

export default AttributeDisplay;
