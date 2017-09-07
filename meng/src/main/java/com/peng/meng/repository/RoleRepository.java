package com.peng.meng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peng.meng.domain.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, String>{

}
