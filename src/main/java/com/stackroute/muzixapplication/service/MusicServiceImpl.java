package com.stackroute.muzixapplication.service;

import com.stackroute.muzixapplication.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapplication.domain.Track;
import com.stackroute.muzixapplication.exceptions.TrackNotFoundException;

import java.util.List;

public interface MusicServiceImpl {
    public Track saveTrack(Track track)throws TrackAlreadyExistsException;
    public List<Track> getAllTrack();
    public Track getTrackById(int id)throws TrackNotFoundException;
    public void deleteTrack(int  id);
    public Track updateTrack( Track track,int id);

}
