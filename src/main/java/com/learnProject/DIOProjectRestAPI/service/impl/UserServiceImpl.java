package com.learnProject.DIOProjectRestAPI.service.impl;

import org.springframework.stereotype.Service;

import com.learnProject.DIOProjectRestAPI.domain.Repository.UserRepository;
import com.learnProject.DIOProjectRestAPI.domain.model.User;
import com.learnProject.DIOProjectRestAPI.service.UserService;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
