import { Children } from "react";

const menuItems = [
    // Home
    {path: '/home', name: 'Home', label: 'Home', icon: 'UserOutlined', url: 'home/index'},
    // Apartment
    {path: '/apartment', name: 'Apartment', label: 'Apartment', icon: 'HomeOutlined', children: [
        {path: '/apartment/apartmentManagement', name: 'Manage Apartments', label: 'Manage Apartment'},
        {path: '/apartment/roomManagement', name: 'Manage Rooms', label: 'Manage Rooms'},
        {path: '/apartment/attribute', name: 'Attributes', label: 'Attributes'},
    ]},
    // Rental
    {path: '/rental', name: 'Rental', label: 'Rental', icon: 'DashboardOutlined', children: [
        {path: '/rental/inspection', name: 'Inspection Appointments', label: 'Inspections'},
        {path: '/rental/leaseTerm', name: 'Manage Lease Terms', label: 'Lease Terms'},
    ]},
    {path: '/system', name: 'System', label: 'System', icon: 'SettingOutlined', children: [
        {path: '/system/position', name: 'Position', label: 'Position'}, 
        {path: '/system/user', name: 'User', label: 'User'},
    ]}, 
    {path: '/customer', name: 'Customer', label: 'Customer', icon: 'TeamOutlined', url: 'customer/index'},
   
]

export default menuItems;