package com.curd.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curd.entity.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer>{

}
