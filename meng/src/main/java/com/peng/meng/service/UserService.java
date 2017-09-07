package com.peng.meng.service;

import org.springframework.stereotype.Service;

import com.peng.meng.domain.User;

@Service
public interface UserService {

  User saveUser(User user);

  User findByUsername(String username);

  User findOne(String id);

}
