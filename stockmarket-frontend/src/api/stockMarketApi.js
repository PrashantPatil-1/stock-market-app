import axios from 'axios';

const API_URL = 'http://localhost:5454/api/stockmarket';

export const addStock = (stock) => axios.post(API_URL, stock);
export const updateStock = (stock) => axios.put(API_URL, stock);
export const deleteStock = (id) => axios.delete(`${API_URL}/${id}`);
export const getStock = (id) => axios.get(`${API_URL}/${id}`);
