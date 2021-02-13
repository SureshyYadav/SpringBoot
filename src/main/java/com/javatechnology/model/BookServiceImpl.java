package com.javatechnology.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechnology.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository repository;

	@Override
	public Book saveBook(Book book) {
		return repository.save(book);
	}

	@Override
	public Book updatebook(Book book, Long id) {
		Book updateBook = null;
		Optional<Book> findById = repository.findById(id);
		if (findById.isPresent()) {
			Book book2 = findById.get();
			book2.setAuthor(book.getAuthor());
			book2.setPrice(book.getPrice());
			book2.setTitle(book.getTitle());
			updateBook = repository.save(book2);
		} else
			updateBook = repository.save(book);
		return updateBook;
	}

	@Override
	public Book getBook(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	@Override
	public void deleteBook(Long id) {
		repository.deleteById(id);

	}

}
