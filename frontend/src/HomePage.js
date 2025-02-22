import React from 'react';
import { useNavigate } from 'react-router-dom';
import TrackList from './components/TrackList';
import './styles/index.scss'; // Import stylów SCSS (nazwa pliku wg uznania)

const HomePage = () => {
    const navigate = useNavigate();

    const handleClick = () => {
        navigate('/npc');
    };

    return (
        <div className="home-page">
            <h1>Measure your npc's taste in music</h1>
            <button onClick={handleClick}>Check</button>

            <div className="track-list-container">
                <h2>Top 20</h2>
                <TrackList ordered={true} />
            </div>
        </div>
    );
};

export default HomePage;