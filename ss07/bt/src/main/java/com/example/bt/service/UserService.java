package com.example.bt.service;

import com.example.bt.model.User;
import com.example.bt.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public void add(User user) {
        userRepository.save(user);
    }
}
