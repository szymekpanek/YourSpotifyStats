import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/npc.scss'; // Import nowego pliku SCSS

const NpcResult = () => {
    const [avgPopularity, setAvgPopularity] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        fetch('http://localhost:8080/api/average-popularity', {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' },
            credentials: 'include' // Upewnia się, że ciasteczka są przesyłane
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Błąd HTTP: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                setAvgPopularity(data);
                setLoading(false);
            })
            .catch(error => {
                console.error('Błąd podczas pobierania średniej popularności:', error);
                setError(error.message);
                setLoading(false);
            });
    }, []);

    const getHipsterResult = (avg) => {
        if (avg < 20) {
            return {
                message: "You are a sigma!",
                image: "/images/sigma.jpg"
            };
        } else if (avg < 50) {
            return {
                message: "You are skibidi",
                image: "/images/bittle.gif"
            };
        } else if (avg < 80) {
            return {
                message: "Just a chill guy",
                image: "/images/chill.jpg"
            };
        } else {
            return {
                message: "You are true NPC",
                image: "/images/npc.jpg"
            };
        }
    };

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error: {error}</p>;

    const result = getHipsterResult(avgPopularity);

    return (
        <div className="npc-result">
            <div className="result-container">
                <div className="result-box">
                    <img src={result.image} alt="Hipster result" className="result-image" />
                    <p className="result-message">{result.message}</p>
                    <p className="popularity-info">The average popularity of your tracks: {avgPopularity}</p>
                    <button onClick={() => navigate(-1)} className="return-button">Back</button>
                </div>
            </div>
        </div>
    );
};

export default NpcResult;
