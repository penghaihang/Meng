package com.peng.meng.service.impl;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.peng.meng.domain.User;
import com.peng.meng.repository.UserRepository;
import com.peng.meng.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService{
  
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  private UserRepository userRepository;
  
  @Override
  public User findOne(String id){
    if(StringUtils.isNotBlank(id)){
      return userRepository.findOne(id);
    }else{
      return null;
    }
  }
  @Override
  public User findByUsername(String username){
    if(StringUtils.isNotBlank(username)){
      return userRepository.findByUsername(username);
    }else{
      return null;
    }
  }
  
  /**
   * 保存用户
   */
  @Override
  public User saveUser(User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);
    return user;
  }

}
