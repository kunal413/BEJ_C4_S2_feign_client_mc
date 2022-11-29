package com.niit.jap.service;

import com.niit.jap.domain.Track;
import com.niit.jap.domain.User;
import com.niit.jap.exception.TrackAlreadyExitsException;

public interface UserTrackService {
   public abstract User addTrack(User user) throws TrackAlreadyExitsException;
   public abstract User addArtistForTrack(String email,Track track)throws TrackAlreadyExitsException;
}
