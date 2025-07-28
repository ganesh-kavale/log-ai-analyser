import React, { useEffect, useState } from 'react';
import { fetchLogs } from '../api';

const LogList = () => {
  const [logs, setLogs] = useState([]);

  useEffect(() => {
    fetchLogs().then(res => setLogs(res.data));
  }, []);

  return (
    <div className="p-4 bg-white shadow rounded">
      <h2 className="text-xl font-bold mb-4">Latest Logs</h2>
      <ul>
        {logs.map((log, idx) => (
          <li key={idx} className="border-b py-2 text-sm">{log}</li>
        ))}
      </ul>
    </div>
  );
};

export default LogList;
