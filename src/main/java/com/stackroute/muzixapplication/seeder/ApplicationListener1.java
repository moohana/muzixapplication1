package com.stackroute.muzixapplication.seeder;

import com.stackroute.muzixapplication.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapplication.domain.Track;
import com.stackroute.muzixapplication.service.MusicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListener1 implements ApplicationListener<ContextRefreshedEvent> {
    private MusicService musicService;
    @Value("${trackId}")
    int trackId;
    @Value("${trackName}")
    String trackName;
    @Value("${comments}")
    String comments;

    public ApplicationListener1(MusicService musicService) {
        this.musicService = musicService;
    }

    public MusicService getMusicService() {
        return musicService;
    }

    public void setMusicService(MusicService musicService) {
        this.musicService = musicService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Track track = new Track(trackId, trackName, comments);
        try {
            musicService.saveTrack(track);
        } catch (TrackAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}



