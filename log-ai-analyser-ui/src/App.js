import React from 'react';
import LogList from './components/LogList';
import AlertList from './components/AlertList';
import LogLevelChart from './components/LogLevelChart';

function App() {
  return (
    <div className="p-6 bg-gray-100 min-h-screen">
      <h1 className="text-3xl font-bold mb-6">LogAI Dashboard</h1>
      <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
        <LogList />
        <AlertList />
      </div>
      <LogLevelChart />
    </div>
  );
}

export default App;
