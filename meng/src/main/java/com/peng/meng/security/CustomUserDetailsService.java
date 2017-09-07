package com.peng.meng.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.peng.meng.domain.User;
import com.peng.meng.service.UserService;
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

  @Autowired
  private UserService userService;
  
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);
		if(user==null){
		  System.out.println("User not found");
          throw new UsernameNotFoundException("Username not found");
		}
		return null;
		/*return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
            user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));*/
	}
	

}
