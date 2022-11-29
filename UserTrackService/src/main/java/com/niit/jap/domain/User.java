package com.niit.jap.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document
public class User {

    private int useId;
    @Id
    private String email;
    private String uname;
    List<Track> trackList;

    public User() {
    }

    public User(int useId, String email, String uname, List<Track> trackList) {
        this.useId = useId;
        this.email = email;
        this.uname = uname;
        this.trackList = trackList;
    }

    public int getUseId() {
        return useId;
    }

    public void setUseId(int useId) {
        this.useId = useId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }
}
