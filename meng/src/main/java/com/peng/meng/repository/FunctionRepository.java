package com.peng.meng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peng.meng.domain.Function;
@Repository
public interface FunctionRepository extends JpaRepository<Function, String>{

}
