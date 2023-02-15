package com.thebookStore.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thebookStore.app.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
