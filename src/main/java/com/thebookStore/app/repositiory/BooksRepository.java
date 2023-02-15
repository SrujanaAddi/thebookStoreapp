package com.thebookStore.app.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thebookStore.app.entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer>{

	public List<Books> findBybookAuthor(String bookAuthor);

}
