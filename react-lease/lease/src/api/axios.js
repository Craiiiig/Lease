// Second encapsulate axios
import axios from 'axios'

// define base url
const baseURL = '/localhost:8080/lease/admin'

// Core second encapsulate axios
class HttpRequest {
    constructor(baseURL) {
        this.baseURL = baseURL
    }

    getInsideConfig() {
        const config = {
            baseURL: this.baseURL,
            headers: {
            }
        }
        return config
    }

    interception(instance) {
        // Add a request interceptor
        axios.interceptors.request.use(function (config) {
            // Do something before request is sent (Eg. check token)
            return config;
        }, function (error) {
            // Do something with request error
            return Promise.reject(error);
        });

        // Add a response interceptor
        axios.interceptors.response.use(function (response) {
            // Any status code that lie within the range of 2xx cause this function to trigger
            // Do something with response data
            return response;
        }, function (error) {
            // Any status codes that falls outside the range of 2xx cause this function to trigger
            // Do something with response error
            return Promise.reject(error);
        });
    }

    request(options) {
        options = { ...this.getInsideConfig(), ...options }
        // Create an axios instance
        const instance = axios.create()
        // Instance interceptors bonding
        this.interception(instance)
        return instance(options)
    }
}

export default new HttpRequest(baseURL)