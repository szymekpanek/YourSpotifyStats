import React, { useState, useEffect } from 'react';
import TrackItem from './TrackItem';

const TrackList = () => {
    const [tracks, setTracks] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetch('http://localhost:8080/api/top-tracks', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
            credentials: 'include'  // Ciasteczka są dołączane do zapytania
        })
            .then(response => {
                if (response.status === 401) {
                    // Jeśli użytkownik nie jest autoryzowany, przekieruj do logowania
                    window.location.href = 'http://localhost:8080/oauth2/authorization/spotify';
                    throw new Error('Unauthorized, redirecting to login');
                }
                if (!response.ok) {
                    throw new Error(`Błąd HTTP: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                if (Array.isArray(data)) {
                    setTracks(data);
                } else {
                    setError('Nieoczekiwany format danych');
                }
                setLoading(false);
            })
            .catch(error => {
                console.error('Błąd podczas pobierania danych:', error);
                setError(error.message);
                setLoading(false);
            });
    }, []);

    if (loading) {
        return <p>Loading...</p>;
    }
    if (error) {
        return <p>Error: {error}</p>;
    }
    return (
        <div className="track-list">
            {tracks.map(track => (
                <TrackItem key={track.id} track={track} />
            ))}
        </div>
    );
};

export default TrackList;
