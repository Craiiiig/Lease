import React, { useState } from 'react';
import {
  MenuFoldOutlined,
  MenuUnfoldOutlined,
} from '@ant-design/icons';
import { Button, Layout, Menu, Avatar, Dropdown, theme } from 'antd';
import { Outlet, useNavigate } from 'react-router-dom';
import MenuConfig from '../config/index';
import * as Icon from "@ant-design/icons"

const { Header, Sider, Content } = Layout;
const iconToElement = (name) => React.createElement(Icon[name]);



const Main = () => {
  const navigate = useNavigate()

  // Control sidebar collapse
  const [collapsed, setCollapsed] = useState(false);

  // Sidebar items
  const menuItems = MenuConfig.map((icon) => {
    const child = {
      key: `${icon.path}`,
      icon: iconToElement(icon.icon),
      label: `${icon.label}`
    }
    if (icon.children) {
      child.children = icon.children.map(item => {
        return {
          key: item.path,
          label: item.label
        }
      })
    }
    return child
  })

  // Dropdown menu items
  const avatarItems = [
    {
      key: '1',
      label: (
        <a target="_blank" rel="noopener noreferrer">
          Profile
        </a>
      ),
    },
    {
      key: '2',
      label: (
        <a onClick={() => logout(!collapsed)} target="_blank" rel="noopener noreferrer" >
          Log out
        </a>
      )
    }
  ]

  // Logout function
  const logout = () => {
    localStorage.removeItem('token')
    navigate('/login')
  }


  // Switch sidebar items
  const selectMenu = (e) => {
    // To store the parent directory, if it has children, find children using parent path
    let data; 
    // / Loop through menu items to find the selected item
    MenuConfig.forEach(item => {
      // find current selected item. 
      // e.keyPath returns an array of all paths, including secondary path. 
      // if keyPath.length = 1, them it doesn't have children. 
      if (item.path === e.keyPath[e.keyPath.length - 1]) {
        data = item
        if (e.keyPath.length > 1) {
          data = item.children.find((child) => {
            return child.path === e.key
          })
        }
      }
    })
    navigate(e.key)
  }


  const {
    token: { colorBgContainer, borderRadiusLG },
  } = theme.useToken();


  return (
    <Layout style={{ minHeight: '100vh' }}>
      <Sider trigger={null} collapsible collapsed={collapsed}>
        <div className="demo-logo-vertical"
          style={{ height: 32, margin: 16 }} >
          <h1 style={{ color: 'white' }}>Logo</h1>
        </div>

        <Menu
          theme="dark"
          mode="inline"
          defaultSelectedKeys={['1']}
          items={menuItems}
          onClick={selectMenu}
        />
      </Sider>
      <Layout>
        <Header style={{
          padding: 0,
          background: colorBgContainer,
          display: 'flex',
          justifyContent: 'space-between',
          alignItems: 'center'
        }}>
          <Button
            type="text"
            icon={collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />}
            onClick={() => setCollapsed(!collapsed)}
            style={{
              fontSize: '16px',
              width: 64,
              height: 64,
            }}
          />
          <Dropdown
            menu={{
              items: avatarItems
            }}
          >
            <Avatar size={48} src={require('../assets/images/user.png')} alt="User" style={{ marginRight: '32px', cursor: 'pointer' }} />
          </Dropdown>
        </Header>
        <Content
          style={{
            margin: '24px 16px',
            padding: 24,
            minHeight: 280,
            background: colorBgContainer,
            borderRadius: borderRadiusLG,
          }}
        >
          <Outlet />
        </Content>
      </Layout>
    </Layout>
  );
};

export default Main;
