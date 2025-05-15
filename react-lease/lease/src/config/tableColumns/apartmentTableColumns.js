import { Tag, Space, Button } from "antd";

export const columns = (handleEdit, handleDelete) => [
    {
        title: 'Name',
        dataIndex: 'name',
        key: 'name',
        align: 'center',
        render: text => <a>{text}</a>,
    },
    {
        title: 'Address',
        dataIndex: 'addressDetail',
        key: 'addressDetail',
        align: 'center',
        render: text => <a>{text}</a>,
    },
    {
        title: 'Available Rooms',
        dataIndex: 'freeRoomCount',
        key: 'freeRoomCount',
        align: 'center',
        render: text => <a>{text}</a>,
    },
    {
        title: 'Total Rooms',
        dataIndex: 'totalRoomCount',
        key: 'totalRoomCount',
        align: 'center',
        render: text => <a>{text}</a>,
    },
    {
        title: 'Province',
        dataIndex: 'provinceName',
        key: 'provinceName',
        align: 'center',
        render: text => <a>{text}</a>,
    },
    {
        title: 'City',
        dataIndex: 'cityName',
        key: 'cityName',
        align: 'center',
        render: text => <a>{text}</a>,
    },
    {
        title: 'District',
        dataIndex: 'districtName',
        key: 'districtName',
        align: 'center',
        render: text => <a>{text}</a>,
    },
    {
        title: 'Contact',
        dataIndex: 'phone',
        key: 'phone',
        align: 'center',
        render: text => <a>{text}</a>,
    },
    {
        title: 'Occupy Status',
        dataIndex: 'status',
        key: 'status',
        align: 'center',
        render: (_, { freeRoomCount }) => {
            if (freeRoomCount > 0) {
                return <Tag color="green">Available</Tag>;
            }
            if (freeRoomCount === 0) {
                return <Tag color="red">Full</Tag>;
            }
        }
    },
    {
        title: 'Released',
        dataIndex: 'isRelease',
        key: 'isRelease',
        align: 'center',
        render: (_, { isRelease }) => {
            if (isRelease === 1) {
                return <Tag color="green">Yes</Tag>;
            }
            if (isRelease === 0) {
                return <Tag color="red">No</Tag>;
            }
        }
    },
    {
        title: 'Action',
        key: 'action',
        align: 'center',
        render: (_, record) => (
            <Space size="middle">
                <Button type="primary" onClick={() => handleEdit(record)}>Edit</Button>
                <Button type="primary" danger onClick={() => handleDelete(record)}>Delete</Button>
            </Space>
        ),
    }
];


export const data = [
            {
                "id": 9,
                "createTime": null,
                "updateTime": null,
                "isDeleted": null,
                "name": "温都水城社区",
                "introduction": "这是一座现代化公寓，位于城市中心，拥有多种户型，从舒适的一居室到宽敞的三居室。设施齐全，配备现代厨房、设施完备的健身房和社交区。公寓内部设计时尚精致，大窗户带来充足自然光线，俯瞰城市美景。24小时安保、智能门禁系统和停车位，确保居民安全与便利。步行可至购物中心、餐厅和公共交通站点，提供舒适便捷的城市生活体验。",
                "districtId": 110114,
                "districtName": "昌平区",
                "cityId": 1101,
                "cityName": "市辖区",
                "provinceId": 11,
                "provinceName": "北京市",
                "addressDetail": "北京市昌平区温都水城北七家镇王府街55号",
                "latitude": "40.103976",
                "longitude": "116.370825",
                "phone": "1234567788",
                "isRelease": 1,
                "totalRoomCount": 6,
                "freeRoomCount": 6
            },
            {
                "id": 10,
                "createTime": null,
                "updateTime": null,
                "isDeleted": null,
                "name": "回龙观社区",
                "introduction": "这是一座现代化公寓，位于城市中心，拥有多种户型，从舒适的一居室到宽敞的三居室。设施齐全，配备现代厨房、设施完备的健身房和社交区。公寓内部设计时尚精致，大窗户带来充足自然光线，俯瞰城市美景。24小时安保、智能门禁系统和停车位，确保居民安全与便利。步行可至购物中心、餐厅和公共交通站点，提供舒适便捷的城市生活体验。",
                "districtId": 110114,
                "districtName": "昌平区",
                "cityId": 1101,
                "cityName": "市辖区",
                "provinceId": 11,
                "provinceName": "北京市",
                "addressDetail": "北京市昌平区回龙观东大街地铁站B东北口8号线",
                "latitude": "40.081628",
                "longitude": "116.363725",
                "phone": "12345678",
                "isRelease": 1,
                "totalRoomCount": 6,
                "freeRoomCount": 6
            }
        ]
