package com.rococo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rococo.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//	User findUserByUsernamePassword(String username, String password);
	@Query("SELECT u FROM User u  WHERE u.username=(:username) AND u.password= (:password)")
	User findUserByUsernamePassword(@Param("username") String username, @Param("password") String password);
}
