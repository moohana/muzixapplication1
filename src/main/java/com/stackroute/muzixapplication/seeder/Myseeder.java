package com.stackroute.muzixapplication.seeder;

import com.stackroute.muzixapplication.Exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapplication.domain.Track;
import com.stackroute.muzixapplication.service.MusicService;
import org.h2.message.Trace;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.naming.Context;
@Component
public class Myseeder implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {
    private MusicService musicService;

    public Myseeder(MusicService musicService) {
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
        Track track= new Track(1,"rajini","super");
        try {
            musicService.saveTrack(track);
        } catch (TrackAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(String... args) throws Exception {
        Track track= new Track(2,"rajini","super");
        try {
            musicService.saveTrack(track);
        } catch (TrackAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}
