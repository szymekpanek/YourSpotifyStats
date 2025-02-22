// App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './HomePage';
// Załóżmy, że masz też NPCPage:
import NPCPage from './components/NpcResult';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<HomePage />} />
                <Route path="/npc" element={<NPCPage />} />
            </Routes>
        </Router>
    );
}

export default App;
