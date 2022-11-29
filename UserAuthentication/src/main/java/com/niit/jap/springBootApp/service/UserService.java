package com.niit.jap.springBootApp.service;

import com.niit.jap.springBootApp.Domain.User;
import com.niit.jap.springBootApp.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public User findByEmailIdAndPassword(String EmailId,String password)throws UserNotFoundException;
    List<User> getAllUsers();
}
