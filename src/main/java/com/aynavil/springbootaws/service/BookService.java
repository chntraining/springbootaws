package com.aynavil.springbootaws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aynavil.springbootaws.entity.Book;
import com.aynavil.springbootaws.repository.BookRepository;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Save a new book to the database.
     * 
     * @param book The book to save
     * @return The saved book
     */
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Retrieve all books from the database.
     * 
     * @return A list of all books
     */
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    /**
     * Retrieve a book by its ID.
     * 
     * @param id The ID of the book
     * @return The book if found
     * @throws Exception if the book is not available
     */
    public Book findBook(Long id) throws Exception {
        return bookRepository.findById(id)
                .orElseThrow(() -> new Exception("Book with ID " + id + " not found."));
    }

    /**
     * Update an existing book.
     * 
     * @param id   The ID of the book to update
     * @param book The new details of the book
     * @return The updated book
     * @throws Exception if the book is not available
     */
    public Book updateBook(Long id, Book book) throws Exception {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new Exception("Book with ID " + id + " not found."));
        existingBook.setBname(book.getBname());
       
        return bookRepository.save(existingBook);
    }

    /**
     * Delete a book by its ID.
     * 
     * @param id The ID of the book to delete
     * @throws Exception if the book is not available
     */
    public void deleteBook(Long id) throws Exception {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new Exception("Book with ID " + id + " not found."));
        bookRepository.delete(existingBook);
    }
}
