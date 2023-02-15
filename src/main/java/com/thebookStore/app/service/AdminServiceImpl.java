package com.thebookStore.app.service;

import com.thebookStore.app.entity.Admin;


public class AdminServiceImpl implements AdminService{

	@Override
	public String login(Admin admin)  {
		if(admin.getEmail() == "Admin@gmail.com" && admin.getPassword() == "Admin@123") {
			return "Admin login Successfull";
		}
		return "Wrong Email or Password";
	}

}
