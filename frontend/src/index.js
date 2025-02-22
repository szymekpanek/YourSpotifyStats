import React from 'react';
import ReactDOM from 'react-dom/client'; // Używamy nowej wersji React 18
import App from './App';
import './styles/index.scss';
import './styles/npc.scss'

const root = ReactDOM.createRoot(document.getElementById('root')); // Pobieramy element DOM o id 'root'
root.render(
    <React.StrictMode>
        <App />
    </React.StrictMode>
);
