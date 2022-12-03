package com.niit.jap.proxy;

import com.niit.jap.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="authentication-service",url="http://authentication-service:8081")
public interface UserProxy
{
    @PostMapping("usertrackapi/user/register")
    public ResponseEntity<?> saveUser(@RequestBody User user);
}
