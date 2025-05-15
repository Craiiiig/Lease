import React from 'react';
import { Row, Col, Card, Table } from 'antd';
import { columns as tableColumns, data as tableData } from '../../config/tableColumns/homeTableColumns';
import LeafletMap from '../../components/map';
const userImg = require('../../assets/images/user-default.png')

const Home = () => {
    const getGreeting = () => {
        const hour = new Date().getHours();
        if (hour >= 8 && hour < 12) return 'Good morning, ';
        if (hour >= 12 && hour < 14) return 'Don\'t forget to have lunch, ';
        if (hour >= 14 && hour < 18) return 'Good afternoon, ';
        if (hour >= 18 && hour <= 23) return 'Good evening, ';
        return 'Have a rest, ';
    };



    return (
        <Row className='home'>
            <Col span={10}>
                <Card hoverable
                    style={{
                        marginBottom: '20px'
                    }}
                >
                    <div className='user'>
                        <img src={userImg} alt='' />
                        <div className='user-info'>
                            <h1 className='user-name'>Admin</h1>
                            <span style={{ fontSize: '1.5em' }}>Role: </span><span className='user-role'>Admin</span>
                        </div>
                    </div>
                    <p><span>{getGreeting()}</span><span>Admin</span></p>
                </Card>
                <Table dataSource={tableData}
                    columns={tableColumns}
                    pagination={false}
                    rowKey={"name"} // tableData.name
                    size='small'
                />

            </Col>

            <Col span={14}
            style={{paddingLeft: '20px'}}>
                <div className='right-entry'>
                    <LeafletMap />
                </div>
            </Col>
        </Row>
    );
}

export default Home;