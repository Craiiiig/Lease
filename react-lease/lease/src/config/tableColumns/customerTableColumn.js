import { Switch } from 'antd';
import defaultAvatar from '../../assets/images/user-default.png';

export const column = [
    {
        title: 'Nickname', 
        dataIndex: 'nickname',
        key: 'nickname',
        render: text => <a>{text}</a>,
    }, 
    {
        title: 'Avatar',
        dataIndex: 'avatarUrl',
        key: 'avatar',
        render: text => <img src={text === null? defaultAvatar : text} alt="avatar" style={{ width: '50px', height: '50px' }} />,
    }, 
    {
        title: 'Contact', 
        dataIndex: 'phone',
        key: 'phone',
        render: text => <a>{text}</a>
    }, 
    {
        title: 'Account Status', 
        dataIndex: 'status',
        key: 'status',
        render: text => <Switch checked={text === 1? true : false} />
    }

]