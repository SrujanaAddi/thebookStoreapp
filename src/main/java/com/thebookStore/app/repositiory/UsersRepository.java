package com.thebookStore.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thebookStore.app.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
