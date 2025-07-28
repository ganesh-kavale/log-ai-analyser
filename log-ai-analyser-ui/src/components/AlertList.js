import React, { useEffect, useState } from 'react';
import { fetchAlerts } from '../api';

const AlertList = () => {
  const [alerts, setAlerts] = useState([]);

  useEffect(() => {
    fetchAlerts().then(res => setAlerts(res.data));
  }, []);

  return (
    <div className="p-4 bg-red-50 shadow rounded">
      <h2 className="text-xl font-bold text-red-700 mb-4">Anomaly Alerts</h2>
      <ul>
        {alerts.map((alert, idx) => (
          <li key={idx} className="border-b py-2 text-sm text-red-700">{alert}</li>
        ))}
      </ul>
    </div>
  );
};

export default AlertList;
