package com.spring.Proxy.JdkProxy;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Override
    public List find() {
        System.out.println("find");
        return null;
    }
}
