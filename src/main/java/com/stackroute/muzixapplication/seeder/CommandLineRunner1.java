package com.stackroute.muzixapplication.seeder;

import com.stackroute.muzixapplication.domain.Track;
import com.stackroute.muzixapplication.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapplication.service.MusicService;
import org.springframework.boot.CommandLineRunner;

public class CommandLineRunner1 implements CommandLineRunner {
    private MusicService musicService;

    public CommandLineRunner1(MusicService musicService) {
        this.musicService = musicService;
    }

    public MusicService getMusicService() {
        return musicService;
    }

    public void setMusicService(MusicService musicService) {
        this.musicService = musicService;
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
