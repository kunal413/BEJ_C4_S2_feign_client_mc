package com.niit.jap.controller;

import com.niit.jap.domain.Track;
import com.niit.jap.domain.User;
import com.niit.jap.exception.TrackAlreadyExitsException;
import com.niit.jap.service.UserTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usertrackapi/user")
public class UserTrackController {
    private UserTrackService userTrackService;
    private ResponseEntity<?>responseEntity;
    @Autowired
    public UserTrackController(UserTrackService userTrackService){
        this.userTrackService=userTrackService;
    }
    @PostMapping("/register")
    public ResponseEntity<?>addTrack(@RequestBody User user)throws TrackAlreadyExitsException{
        try {
            user.setTrackList(new ArrayList<>());
            responseEntity= new ResponseEntity<>(userTrackService.addTrack(user), HttpStatus.OK);
        }
        catch (Exception e){
            throw new TrackAlreadyExitsException();
        }
        return responseEntity;
    }
    @PutMapping("/addtrack/{email}")
    public ResponseEntity<?> addArtistToTrack(@PathVariable String email, @RequestBody Track track) throws TrackAlreadyExitsException{
        try {
            return new ResponseEntity<>(userTrackService.addArtistForTrack(email, track),HttpStatus.OK);

        }
        catch (Exception e){
            throw new TrackAlreadyExitsException();
        }
    }
}
