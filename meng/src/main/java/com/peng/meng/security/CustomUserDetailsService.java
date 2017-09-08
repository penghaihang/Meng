package com.peng.meng.security;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.peng.meng.domain.User;
import com.peng.meng.service.UserService;

@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.findByUsername(username);
    if (user == null) {
      System.out.println("User not found");
      throw new UsernameNotFoundException("Username not found");
    }
    return user;
    /*
     * return new org.springframework.security.core.userdetails.User(user.getUsername(),
     * user.getPassword(), user.getState().equals("Active"), true, true, true,
     * getGrantedAuthorities(user));
     */
  }

  public List<GrantedAuthority> getGrantedauthoritys() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    SimpleGrantedAuthority e = new SimpleGrantedAuthority("ROLE_ADMIN");
    authorities.add(e);
    return authorities;
  }

}
