package com.niit.jap.springBootApp.service;

import com.niit.jap.springBootApp.Domain.User;
import com.niit.jap.springBootApp.exception.UserNotFoundException;
import com.niit.jap.springBootApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByEmailIdAndPassword(String emailId, String password) throws UserNotFoundException {
        User user = userRepository.findByEmailIdAndUserPassword(emailId,password);
        if (user==null){
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
