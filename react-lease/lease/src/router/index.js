// router/index.js
import { createBrowserRouter, Navigate } from 'react-router-dom';
import Main from '../pages/main';
import Home from '../pages/home';
import Apartment from '../pages/apartment';
import Rental from '../pages/rental';
import User from '../pages/user';
import Staff from '../pages/staff';
import Login from '../pages/login';
import ApartmentManagement from '../pages/apartment/apartmentManagement';
import RoomManagement from '../pages/apartment/roomManagement';
import Attributes from '../pages/apartment/attributes';
import Inspection from '../pages/rental/inspection';
import LeaseTerm from '../pages/rental/leaseTerm';

const routes = [
    {
        path: '/',
        element: <Main />,
        children: [
          {
            path: '', 
            element: <Navigate to="home" replace />
          },
          {
            path: 'home',
            element: <Home />
          },
          {
            path: 'apartment',
            element: <Apartment />, 
            children: [
             {   path: 'apartmentManagement',
                element: <ApartmentManagement />
            }, 
            {
                path: 'roomManagement',
                element: <RoomManagement />
            }, 
            {
                path: 'attribute',
                element: <Attributes />
            }
            ]
          },
          {
            path: 'rental',
            element: <Rental />, 
            children: [
                {
                    path: 'inspection',
                    element: <Inspection />
                }, 
                {
                    path: 'leaseTerm',
                    element: <LeaseTerm />
                }
            ]
          },
          {
            path: 'user',
            element: <User />
          },
          {
            path: 'staff',
            element: <Staff />
          }
        ]
      },
      {
        path: '/login',
        element: <Login />
      }
];

  
export default createBrowserRouter(routes);
