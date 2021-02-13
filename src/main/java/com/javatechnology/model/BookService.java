package com.javatechnology.model;

import java.util.List;

public interface BookService {
	public Book saveBook(Book book);
	public Book updatebook(Book book, Long id);
	public Book getBook(Long id);
	public List<Book> getAllBooks();
	public void deleteBook(Long id);

}
