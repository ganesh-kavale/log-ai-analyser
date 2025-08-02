import React, { useEffect, useState } from 'react';
import { fetchLogs } from '../api';
import { BarChart, Bar, XAxis, YAxis, Tooltip, ResponsiveContainer, CartesianGrid } from 'recharts';

const parseLogLevels = (logs) => {
  const levels = { INFO: 0, WARN: 0, ERROR: 0, DEBUG: 0 };

  logs.forEach(log => {
    if (log.includes('ERROR')) levels.ERROR += 1;
    else if (log.includes('WARN')) levels.WARN += 1;
    else if (log.includes('DEBUG')) levels.DEBUG += 1;
    else levels.INFO += 1;
  });

  return Object.entries(levels).map(([level, count]) => ({ level, count }));
};

const LogLevelChart = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    const loadLogs = async () => {
      const res = await fetchLogs();
      const chartData = parseLogLevels(res.data);
      setData(chartData);
    };

    loadLogs();
    const interval = setInterval(loadLogs, 5000);

    return () => clearInterval(interval);
  }, []);

  return (
    <div className="p-4 bg-white shadow rounded mt-4">
      <h2 className="text-xl font-bold mb-4">Log Level Summary</h2>
      <ResponsiveContainer width="100%" height={250}>
        <BarChart data={data}>
          <XAxis dataKey="level" />
          <YAxis />
          <Tooltip />
          <CartesianGrid strokeDasharray="3 3" />
          <Bar dataKey="count" fill="#3182CE" />
        </BarChart>
      </ResponsiveContainer>
    </div>
  );
};

export default LogLevelChart;
