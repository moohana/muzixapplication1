package com.stackroute.muzixapplication.repository;

import com.stackroute.muzixapplication.domain.Track;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface MusicRepository extends CrudRepository<Track,Integer> {
}
