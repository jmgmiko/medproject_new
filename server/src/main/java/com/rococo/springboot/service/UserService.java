package com.rococo.springboot.service;

import java.util.List;

import com.rococo.springboot.model.User;

public interface UserService {
	
	public User getPersonInfo(User UserModel);	
	public List<User> getAll();
	public void registerPerson(User UserModel);
	public User getPersonByUsernamePassword(String username,String password);
}
