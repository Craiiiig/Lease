import { Modal, Form, Input, DatePicker, InputNumber } from 'antd';
import { useEffect } from 'react';
import dayjs from 'dayjs';

const EditLeaseModal = ({ visible, onCancel, onOk, record }) => {
    const [form] = Form.useForm();

    // 数据变化时回显
    useEffect(() => {
        if (record) {
            form.setFieldsValue({
                name: record.name,
                phone: record.phone || record.apartmentInfo?.phone,
                identificationNumber: record.identificationNumber,
                provinceId: record.apartmentInfo?.provinceId,
                cityId: record.apartmentInfo?.cityId,
                districtId: record.apartmentInfo?.districtId,
                apartmentId: record.apartmentInfo?.id,
                roomId: record.roomInfo?.id,
                leaseStartDate: record.leaseStartDate ? dayjs(record.leaseStartDate) : null,
                leaseEndDate: record.leaseEndDate ? dayjs(record.leaseEndDate) : null,
                paymentTypeId: record.paymentType?.id,
                leaseTermId: record.leaseTerm?.id,
                rent: record.roomInfo?.rent,
                deposit: record.deposit,
                additionalInfo: record.additionalInfo || '无',
            });
        }
    }, [record, form]);

    const handleSubmit = () => {
        form.validateFields().then(values => {
            onOk(values); // 提交数据
        });
    };

    return (
        <Modal title="修改租约" open={visible} onCancel={onCancel} onOk={handleSubmit}>
            <Form form={form} layout="vertical">
                <Form.Item label="姓名" name="name">
                    <Input />
                </Form.Item>
                <Form.Item label="手机号" name="phone">
                    <Input />
                </Form.Item>
                <Form.Item label="身份证号码" name="identificationNumber">
                    <Input />
                </Form.Item>
                {/* 房间选择的省市区 + 公寓 + 房间号 */}
                {/* 起止时间 */}
                <Form.Item label="开始时间" name="leaseStartDate">
                    <DatePicker />
                </Form.Item>
                <Form.Item label="结束时间" name="leaseEndDate">
                    <DatePicker />
                </Form.Item>
                {/* 付款方式、租期 */}
                <Form.Item label="租金（元/月）" name="rent">
                    <InputNumber min={0} />
                </Form.Item>
                <Form.Item label="押金（元）" name="deposit">
                    <InputNumber min={0} />
                </Form.Item>
                <Form.Item label="备注信息" name="additionalInfo">
                    <Input />
                </Form.Item>
            </Form>
        </Modal>
    );
};

export default EditLeaseModal;
