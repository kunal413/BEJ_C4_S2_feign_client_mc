package com.niit.jap.repository;

import com.niit.jap.domain.Track;
import com.niit.jap.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserTrackRepository extends MongoRepository<User,String> {
    User findByEmail(String email);
}
