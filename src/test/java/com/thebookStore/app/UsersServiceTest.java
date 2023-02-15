package com.thebookStore.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thebookStore.app.entity.Users;
import com.thebookStore.app.exception.UsersException;
import com.thebookStore.app.service.UserService;

@SpringBootTest
public class UsersServiceTest {
	private static final Integer NUll = null;
	@Autowired
	private UserService userService;

		@Test
		void addUsersTest() {
			assertNotNull(userService.addUser(new Users(1, "Name", "EmailId", "password", null, null)));
		}
		@Test
		void updateUsersTest() throws UsersException {
			assertNotNull(userService.updateUser(new Users(1, "name", "email", "password", null, null)));
		}
		@Test
		void removeUsersTest() throws UsersException {
			assertNotNull(userService.removeUser(100));
		}
		@Test
		void showAllUsersTest() {
			assertNotNull(userService.showAllUsers());
		}
		@Test
		void getUsersByIdTest() throws UsersException {
			assertNotNull(userService.getUserByUserID(1));
		}

}
