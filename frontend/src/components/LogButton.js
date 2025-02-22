// LogoutButton.js
import React from 'react';

const LogoutButton = () => {
    const handleLogout = () => {
        fetch('http://localhost:8080/api/logout', {
            method: 'POST', // Upewnij się, że używasz metody POST
            credentials: 'include'
        })
            .then(response => {
                if (response.ok) {
                    // Po wylogowaniu przekierowujemy użytkownika do strony autoryzacji
                    window.location.href = 'http://localhost:8080/oauth2/authorization/spotify';
                } else {
                    throw new Error('Logout failed');
                }
            })
            .catch(error => console.error('Error during logout:', error));
    };

    return (
        <button onClick={handleLogout}>
            Logout
        </button>
    );
};

export default LogoutButton;
