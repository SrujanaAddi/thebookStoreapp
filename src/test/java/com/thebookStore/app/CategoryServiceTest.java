package com.thebookStore.app;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.springframework.beans.factory.annotation.Autowired;



import com.thebookStore.app.entity.Category;
import com.thebookStore.app.exception.CategoryException;
import com.thebookStore.app.service.CategoryService;



@SpringBootTest
class CategoryServiceTests {
	
	@Autowired
	private CategoryService categoryService;

	@Test
	void addCategoriesTest(){
		assertNotNull(categoryService.createCategory(new Category(100,"CategoryName",null)));
		
	}
	@Test
	void updateCategoriesTest() {
		assertNotNull(categoryService.updateCategory(new Category(100,"CategoryName",null)));
	}
	@Test
	void getCategoriesByIdTest() throws CategoryException {
		assertNotNull(categoryService.getCategoryById(100));
	}
	@Test
	void getCategoriesByIdExceptionTest() {
		assertThrows(CategoryException.class,()->categoryService.getCategoryById(200));
	}

	
	

}
