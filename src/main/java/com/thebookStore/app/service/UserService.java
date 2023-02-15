package com.thebookStore.app.service;

import java.util.List;

import com.thebookStore.app.entity.Users;
import com.thebookStore.app.exception.UsersException;

public interface UserService {
	public Users addUser(Users user);

	public Users updateUser(Users user) throws UsersException;

	public Users removeUser(Integer UserId) throws UsersException;

	public List<Users> showAllUsers();

	public Users getUserByUserID(Integer UserId) throws UsersException;

}
