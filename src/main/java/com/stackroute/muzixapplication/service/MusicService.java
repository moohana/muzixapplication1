package com.stackroute.muzixapplication.service;

import com.stackroute.muzixapplication.Exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapplication.domain.Track;
import com.stackroute.muzixapplication.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {
    private MusicRepository musicRepository;
@Autowired
    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public MusicRepository getMusicRepository() {
        return musicRepository;
    }

    public void setMusicRepository(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
    if(musicRepository.existsById(track.getTrackId())){

        throw new TrackAlreadyExistsException("Track already exists");
    }
        Track savedTrack = musicRepository.save(track);
       if(savedTrack==null){
           throw new TrackAlreadyExistsException("Track already exists");
       }
        return savedTrack;

    }
    public List<Track> getAllTrack() {

        List<Track> getTrack= (List)musicRepository.findAll();
        return getTrack;
    }

    public Track getTrackById(int id) {
        Optional<Track> getId = musicRepository.findById(id);
        return getId.get();

    }
//    public Track getTrackByName(String name) {
//        Track gettrackName = musicRepository.searchBytrackName(name);
//        return gettrackName.get();
//
//    }

    public void deleteTrack(int  id) {
        musicRepository.deleteById(id);

    }
    public Track updateTrack( Track track,int id){

        Track tracktobeupdated=musicRepository.findById(id).get();
        tracktobeupdated.setTrackName(track.getTrackName());
        return musicRepository.save(tracktobeupdated);

    }
}



