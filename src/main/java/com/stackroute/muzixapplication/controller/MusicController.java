package com.stackroute.muzixapplication.controller;

import com.stackroute.muzixapplication.domain.Track;
import com.stackroute.muzixapplication.service.MusicService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MusicController {
    private MusicService musicservice;
    @Autowired
public MusicController(MusicService musicservice){
    this.musicservice= musicservice;
}
    @PostMapping("/track")

    public ResponseEntity<Track> saveTrack(@RequestBody Track track)
    {
        Track savedTrack=musicservice.saveTrack(track);
        return new ResponseEntity<Track>(savedTrack, HttpStatus.OK);

    }
    @GetMapping("tracks")
    public ResponseEntity<?>getAllTrack(){

        List<Track> getTrack=musicservice.getAllTrack();
        return new ResponseEntity<List<Track>>(getTrack,HttpStatus.OK);

    }
    @GetMapping("/track/{id}")
    public ResponseEntity<?>getTrackById(@PathVariable("id") int id){

        Track getId=musicservice.getTrackById(id);
        return new ResponseEntity<Track>(getId,HttpStatus.OK);

    }
    @PutMapping("track/{id}")

    public ResponseEntity<Track>updateTrack(@RequestBody Track track,@PathVariable int id)
    {
        Track updatedTrack=musicservice.updateTrack(track,id);
        return new ResponseEntity<Track>(updatedTrack, HttpStatus.OK);

    }
    @DeleteMapping("track/{id}")
    public ResponseEntity<?>deleteTrack(@PathVariable("id") int id){
        musicservice.deleteTrack(id);
        return new ResponseEntity<List<Track>>(musicservice.getAllTrack(),HttpStatus.OK);
    }

}
