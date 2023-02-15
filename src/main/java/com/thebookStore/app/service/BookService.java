package com.thebookStore.app.service;

import java.util.List;

import com.thebookStore.app.entity.Books;
import com.thebookStore.app.exception.BooksException;

import com.thebookStore.app.exception.CategoryException;

public interface BookService {

	public Books addBooks(Books book);

	public Books removeBooksbyId(Integer bookId) throws BooksException;

	public Books updateBooks(Books updateBook) throws BooksException;

	public List<Books> getAllBooks();

	public Books getBookById(Integer BookId) throws BooksException;
	
	public Books addBooksToCategoryByCategoryId(Books book, Integer categoryId ) throws CategoryException;
	
	public List<Books> getBooksByAuthorName(String bookAuthor)throws BooksException;
	
	

}
