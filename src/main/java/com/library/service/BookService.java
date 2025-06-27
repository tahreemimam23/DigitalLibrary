package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Books;
import com.library.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;

	public Books saveBook(Books b) {
		return bookRepo.save(b);
	}

	public List<Books> getAllBooks() {
		return bookRepo.findAll();
	}

	public Optional<Books> getBook(int bid) {
		return bookRepo.findById(bid);
	}

	public Books updateBook(Books b, int bid) {
		Optional<Books> theBook = bookRepo.findById(bid);
		Books book = theBook.get();
		book.setBname(b.getBname());
		book.setBauth(b.getBauth());
		book.setPyear(b.getPyear());
		book.setBcategory(b.getBcategory());
		book.setIsbn(b.getIsbn());
		book.setStatus(b.getStatus());
		return bookRepo.save(book);
	}

	public void deleteBook(int bid) {
		bookRepo.deleteById(bid);
	}

}
