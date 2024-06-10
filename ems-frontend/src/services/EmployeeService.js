import axios from 'axios';

const REST_API_BASE_URL = 'http://springboot-ems-env.eba-yx3yw7zb.eu-north-1.elasticbeanstalk.com/api/employees'

export const listEmployees = () => axios.get(REST_API_BASE_URL);

export const createEmployee = (employee) => axios.post(REST_API_BASE_URL, employee);

export const getEmployee = (employeeId) => axios.get(REST_API_BASE_URL + '/' + employeeId);

export const updateEmployee = (employeeId, updEmployee) => axios.put(REST_API_BASE_URL + '/' + employeeId, updEmployee);

export const deleteEmployee = (employeeId) => axios.delete(REST_API_BASE_URL + '/' + employeeId);




//export const listEmployees = () => return axios.get(REST_API_BASE_URL); one liner code
//Axios, which is a popular library is mainly used to send asynchronous HTTP requests to REST endpoints
//axios has get method 
/*
export const listEmployees = () => {
    return axios.get(REST_API_BASE_URL);
} */