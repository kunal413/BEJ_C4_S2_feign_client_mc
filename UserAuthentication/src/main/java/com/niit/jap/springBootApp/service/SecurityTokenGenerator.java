package com.niit.jap.springBootApp.service;

import com.niit.jap.springBootApp.Domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String>generateToken(User user);
}
