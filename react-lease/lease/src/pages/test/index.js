import { Button, Form, Input, Select } from "antd";
import AttributeDisplay from "../../components/attributeDisplay";
import { roomAttributes } from "../../mock";
import { useState } from "react";

const Test = () => {


    const [form] = Form.useForm();
    const [formLayout, setFormLayout] = useState('inline');
    const onFormLayoutChange = ({ layout }) => {
        setFormLayout(layout);
    };
    const records = [
        {
            "id": 1,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "name": "停车费",
            "feeValueList": [
                {
                    "id": 3,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "400",
                    "unit": "元/月",
                    "feeKeyId": 1
                },
                {
                    "id": 2,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "300",
                    "unit": "元/月",
                    "feeKeyId": 1
                },
                {
                    "id": 1,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "200",
                    "unit": "元/月",
                    "feeKeyId": 1
                }
            ]
        },
        {
            "id": 2,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "name": "网费",
            "feeValueList": [
                {
                    "id": 7,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "500",
                    "unit": "元/年",
                    "feeKeyId": 2
                },
                {
                    "id": 6,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "1000",
                    "unit": "元/年",
                    "feeKeyId": 2
                },
                {
                    "id": 5,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "60",
                    "unit": "元/月",
                    "feeKeyId": 2
                },
                {
                    "id": 4,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "50",
                    "unit": "元/月",
                    "feeKeyId": 2
                }
            ]
        },
        {
            "id": 6,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "name": "电费",
            "feeValueList": [
                {
                    "id": 15,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "0.5",
                    "unit": "元/度",
                    "feeKeyId": 6
                },
                {
                    "id": 14,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "1",
                    "unit": "元/度",
                    "feeKeyId": 6
                },
                {
                    "id": 13,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "1.5",
                    "unit": "元/度",
                    "feeKeyId": 6
                }
            ]
        },
        {
            "id": 7,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "name": "水费",
            "feeValueList": [
                {
                    "id": 19,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "7",
                    "unit": "元/吨",
                    "feeKeyId": 7
                },
                {
                    "id": 18,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "8",
                    "unit": "元/吨",
                    "feeKeyId": 7
                },
                {
                    "id": 17,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "9",
                    "unit": "元/吨",
                    "feeKeyId": 7
                },
                {
                    "id": 16,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "10",
                    "unit": "元/吨",
                    "feeKeyId": 7
                }
            ]
        },
        {
            "id": 8,
            "createTime": null,
            "updateTime": null,
            "isDeleted": null,
            "name": "取暖费",
            "feeValueList": [
                {
                    "id": 22,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "1500",
                    "unit": "元/年",
                    "feeKeyId": 8
                },
                {
                    "id": 21,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "1200",
                    "unit": "元/年",
                    "feeKeyId": 8
                },
                {
                    "id": 20,
                    "createTime": null,
                    "updateTime": null,
                    "isDeleted": null,
                    "name": "1000",
                    "unit": "元/年",
                    "feeKeyId": 8
                }
            ]
        }
    ].flatMap(record =>
        record.feeValueList.map(value => {
          const label = `${record.name}-${value.name}${value.unit}`;
          return {
            label,
            value: label,
          };
        })
      );



    return (
        <Form
            layout={formLayout}
            form={form}
            initialValues={{ layout: formLayout }}
            onValuesChange={onFormLayoutChange}
            style={{ maxWidth: formLayout === 'inline' ? 'none' : 600 }}
        >

            <Select
                mode="multiple"
                size='middle'
                placeholder="Please select"
                defaultValue={[]}
                style={{ width: '100%' }}
                options={records}
            />
        </Form>
    );
}

export default Test;