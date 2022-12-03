package com.niit.jap.service;

import com.niit.jap.domain.Track;
import com.niit.jap.domain.User;
import com.niit.jap.exception.TrackAlreadyExitsException;
import com.niit.jap.proxy.UserProxy;
import com.niit.jap.repository.UserTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserTrackServiceImpl implements UserTrackService {
    public UserTrackRepository userTrackRepository;
    @Autowired
    public UserProxy userProxy;
    @Autowired
    public UserTrackServiceImpl(UserTrackRepository userTrackRepository){
        this.userTrackRepository=userTrackRepository;
    }
    @Override
    public User addTrack(User user) throws TrackAlreadyExitsException {
        if(userTrackRepository.findById(user.getEmail()).isPresent()){
            throw  new TrackAlreadyExitsException();
        }
        User saveUser = userTrackRepository.save(user);
        if (!(saveUser.getEmail().isEmpty())){
            ResponseEntity responseEntity = userProxy.saveUser(user);
            System.out.println(responseEntity.getBody());
        }
        return saveUser;
    }

    @Override
    public User addArtistForTrack(String email,Track track) throws TrackAlreadyExitsException {
        if (userTrackRepository.findById(email).isEmpty()){
            throw new TrackAlreadyExitsException();
        }
        User user = userTrackRepository.findByEmail(email);
        if (user.getTrackList()==null){
            user.setTrackList(Arrays.asList(track));
        }
        else {
            List<Track> tracks=user.getTrackList();
            tracks.add(track);
            user.setTrackList(tracks);
        }
        return userTrackRepository.save(user);
    }
}
