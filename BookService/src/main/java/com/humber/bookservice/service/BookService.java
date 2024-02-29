package com.humber.bookservice.service;

import com.humber.bookservice.entity.Book;
import com.humber.bookservice.entity.BookStatus;
import com.humber.bookservice.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Service class for managing books.
 */
@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    /**
     * Fetches all books from the repository.
     *
     * @return a list of all books
     */
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    /**
     * Fetches the status of a book with a given ID.
     *
     * @param bookId the ID of the book
     * @return the status of the book
     * @throws IllegalArgumentException if a book with the given ID does not exist
     */
    public BookStatus getBookStatus(Long bookId) {
        return bookRepository.findById(bookId)
                .map(Book::getStatus)
                .orElseThrow(() -> new IllegalArgumentException("Book with id " + bookId + " not found"));
    }

    /**
     * Updates the status of a book with a given ID.
     *
     * @param bookId the ID of the book
     * @param newStatus the new status to set
     * @return the updated book
     * @throws IllegalArgumentException if a book with the given ID does not exist
     */
    @Transactional
    public Book updateBookStatus(Long bookId, BookStatus newStatus) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book with id " + bookId + " not found"));
        book.setStatus(newStatus);
        return bookRepository.save(book);
    }

}
