package com.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Books;
import com.library.service.BookService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@PostMapping("/add")
	public Books addBook(@RequestBody Books b) {
		return bookService.saveBook(b);
	}
	
	@GetMapping("/getAll")
	public List<Books>  getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/getAll/{id}")
	public Optional<Books>  getBook(@PathVariable int id) {
		return bookService.getBook(id);
	}
	
	@PutMapping("/update/{id}")
	public Books updateBook(@RequestBody Books b,@PathVariable int id) {
		return bookService.updateBook(b,id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void  deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
	}
}
