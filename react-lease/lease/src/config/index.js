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
    {path: '/user', name: 'User', label: 'User', icon: 'UserOutlined', url: 'user/index'},
    {path: '/staff', name: 'Staff', label: 'Staff', icon: 'TeamOutlined', url: 'staff/index'},
]

export default menuItems;