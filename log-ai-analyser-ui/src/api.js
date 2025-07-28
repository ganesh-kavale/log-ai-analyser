import axios from 'axios';

const API_BASE = "http://localhost:8053/api/logs";

export const fetchLogs = () => axios.get(`${API_BASE}/log-ai-analyser`);
export const fetchAlerts = () => axios.get(`${API_BASE}/alerts`);
