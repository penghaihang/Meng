package com.peng.meng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.peng.meng.domain.User;
@Repository
public interface UserRepository extends JpaRepository<User, String>{
  
  @Query("from User where username=?1")
  User findByUsername(String username);

}
