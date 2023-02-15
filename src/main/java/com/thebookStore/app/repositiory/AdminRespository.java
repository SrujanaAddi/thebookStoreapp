package com.thebookStore.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thebookStore.app.entity.Admin;

@Repository
public interface AdminRespository extends JpaRepository<Admin, Integer>{

}
