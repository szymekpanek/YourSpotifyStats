// TrackItem.js
import React from 'react';

const TrackItem = ({ track }) => {
    return (
        <div className="track-item">
            <span className="track-number"></span>
            <img src={track.album.images[0].url} alt={track.album.name} />
            <div className="track-info">
                <strong className="track-title">{track.name}</strong>
                <span className="track-artist">{track.artists.map(artist => artist.name).join(', ')}</span>
            </div>
        </div>
    );
};

export default TrackItem;
