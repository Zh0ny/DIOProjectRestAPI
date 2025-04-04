package com.learnProject.DIOProjectRestAPI.service;

import com.learnProject.DIOProjectRestAPI.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}
