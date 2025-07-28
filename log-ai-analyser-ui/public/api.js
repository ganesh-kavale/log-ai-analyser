import axios from 'axios';

const API_BASE = "http://localhost:8053/api";

export const fetchLogs = () => axios.get(`${API_BASE}/logs`);
export const fetchAlerts = () => axios.get(`${API_BASE}/alerts`);
