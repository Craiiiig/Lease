import http from './axios';

export const getData = () => {
    return http.request({
        url: '/api/getData',
        method: 'get',

    }
    )
}

export const getUser = (params) => {
    return http.request({
        url: '/user/getUser',
        method: 'get',
        params
    }
    )
}

export const addUser = (data) => {
    return http.request({
        url: '/user/addUser',
        method: 'post',
        data
    }
    )
}

export const updateUser = (data) => {
    return http.request({
        url: '/user/updateUser',
        method: 'post',
        data
    }
    )
}

export const deleteUser = (data) => {
    return http.request({
        url: '/user/deleteUser',
        method: 'post',
        data
    }
    )
}

export const getMenu = (data) => {
    return http.request({
        url: '/permission/getMenu',
        method: 'post',
        data
    }
    )
}