package com.javatechnology.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechnology.model.Book;
import com.javatechnology.model.BookService;

@RestController
public class HelloController {
	@Autowired
	private BookService service;
	@RequestMapping("/")
	public String welcomePage() {
		return "Welcome to Spring boot";
	}
	@RequestMapping(value="/saveBook",method=RequestMethod.POST)
	public Book saveBook(@RequestBody Book book) {
		return service.saveBook(book);
		
	}
	@RequestMapping(value="/updateBook/{id}",method=RequestMethod.PUT)
	public Book updateBook(@RequestBody Book book,@PathVariable("id") Long id) {
		return service.updatebook(book, id);
		
	}
	
	@RequestMapping(value="/findAllBooks",method=RequestMethod.GET)
	public List<Book> findAllBooks() {
		return service.getAllBooks();
		
	}
	
	@RequestMapping(value="/getBookById/{id}",method=RequestMethod.GET)
	public Book getBookById(@PathVariable("id") Long id) {
		return service.getBook(id);
		
	}
	
	@RequestMapping(value="/deleteBook/{id}",method=RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") Long id) {
		 service.deleteBook(id);
		
	}
	

}
