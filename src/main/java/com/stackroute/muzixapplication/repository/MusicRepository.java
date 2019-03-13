package com.stackroute.muzixapplication.repository;

import com.stackroute.muzixapplication.domain.Track;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MusicRepository extends CrudRepository<Track,Integer> {

    @Query (value="SELECT * FROM Track  where trackName=?1",nativeQuery = true)
    Track searchBytrackName(String trackName);
}

