package com.aynavil.springbootaws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aynavil.springbootaws.entity.Book;
import com.aynavil.springbootaws.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	// Save a book
	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		Book savedBook = bookService.saveBook(book);
		return ResponseEntity.ok(savedBook);
	}

	// Get all books
	@GetMapping
	public ResponseEntity<List<Book>> findBooks() {
		List<Book> books = bookService.findBooks();
		return ResponseEntity.ok(books);
	}

	// Get a book by ID
	@GetMapping("/{id}")
	public ResponseEntity<Book> findBook(@PathVariable Long id) {
		try {
			Book book = bookService.findBook(id);
			return ResponseEntity.ok(book);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	// Update a book
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
		try {
			Book updatedBook = bookService.updateBook(id, book);
			return ResponseEntity.ok(updatedBook);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete a book
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		try {
			bookService.deleteBook(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

}
