package com.rococo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rococo.springboot.model.User;
import com.rococo.springboot.model.UserAbility;

@Repository
public interface UserAbilityRepository extends JpaRepository<UserAbility, Integer> {

}
