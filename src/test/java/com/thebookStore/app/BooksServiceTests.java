package com.thebookStore.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thebookStore.app.entity.Books;
import com.thebookStore.app.exception.BooksException;
import com.thebookStore.app.exception.CategoryException;
import com.thebookStore.app.service.BookService;


@SpringBootTest
class BooksServiceTests {

	@Autowired
	private BookService bookService;
	
	@Test
	void addBooksTest() {
		assertNotNull(bookService.addBooks(new Books(1, "TestBook", "TestAuthor","Testoublisher",1000.0f)));
	}
	
	@Test
	void updateBooksTest() throws BooksException{
		assertNotNull(bookService.updateBooks(new Books(1, "Testbook", "Testauthor","Testpublisher" , 1000.0f))) ;
		
	}
	
	@Test
	void updateBooksTestExceptionTest() {
		
		assertThrows(BooksException.class,()->bookService.updateBooks(new Books(100, "testbook", null, null, null)));
	}
	
	@Test
	void getAllBooksTest() {
		assertNotNull(bookService.getAllBooks());
	}
	
	
	
	@Test
	void getBookByIdTest() throws BooksException {
		assertNotNull(bookService.getBookById(1));
	}
	
	@Test
	void getBookByIdExceptionTest() {
		
		assertThrows(BooksException.class,()->bookService.getBookById(500));
	}
	
	
	@Test
	void addBookToCategoryByCategoryIdTest() throws CategoryException{
		assertNotNull(bookService.addBooksToCategoryByCategoryId(new Books(300, "testBook1", "TestAuthor1", "Testpublisher1", 1000.0f), 1));
	}
	
	@Test
	void addBookToCategoryByCategoryIdExceptionTest() {
		assertThrows(CategoryException.class, ()->bookService.addBooksToCategoryByCategoryId(new Books(1000, "testbook2", "testauthor2", "testpublisher2", 1000.0f), 100));
	}
	
	@Test
	void getBooksByAuthorNameTest() throws BooksException{
		assertNotNull(bookService.getBooksByAuthorName("TestAuthor1"));
	}
	
	@Test
	void getBooksByAuthorNameExceptionTest() {
		assertThrows(BooksException.class, ()->bookService.getBooksByAuthorName("Test"));
	}
	

	@Test
	void removeBooksByIdTest() throws BooksException {
		assertNotNull(bookService.removeBooksbyId(100));
	}
	
	@Test
	void removeBooksByIdExceptionTest() {
		assertThrows(BooksException.class, ()->bookService.removeBooksbyId(500));
	}
	

}
