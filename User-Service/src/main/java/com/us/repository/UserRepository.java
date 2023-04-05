package com.us.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.us.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
