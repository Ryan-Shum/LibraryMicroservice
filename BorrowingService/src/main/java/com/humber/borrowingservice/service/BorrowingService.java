package com.humber.borrowingservice.service;

import com.humber.borrowingservice.client.BookClient;
import com.humber.borrowingservice.entity.BookStatus;
import org.springframework.stereotype.Service;

/**
 * Entity class for Book in the borrowing service.
 *
 * This class represents a book with properties like id, title, author, genre, description and status.
 * It uses Lombok annotations for boilerplate code reduction.
 */
@Service
public class BorrowingService {
    private final BookClient bookClient;

    /**
     * Constructor for the BorrowingService class.
     *
     * @param bookClient the Feign client used to communicate with the book-service
     */
    public BorrowingService(BookClient bookClient) {
        this.bookClient = bookClient;
    }

    /**
     * Borrows a book.
     *
     * This method checks if the book is available for borrowing, and if so, updates its status to LOANED.
     * If the book is not available, it throws an IllegalArgumentException.
     *
     * @param bookId the ID of the book to borrow
     * @throws IllegalArgumentException if the book is not available for borrowing
     */
    public void borrowBook(long bookId) {
        BookStatus status = bookClient.getBookStatus(bookId);
        if (status != BookStatus.AVAILABLE) {
            throw new IllegalArgumentException("Book with id " + bookId + " is unavailable for borrowing");
        }
        bookClient.updateBookStatus(bookId, BookStatus.LOANED);
    }

    /**
     * Returns a book.
     *
     * This method checks if the book is currently loaned, and if so, updates its status to AVAILABLE.
     * If the book is not loaned, it throws an IllegalArgumentException.
     *
     * @param bookId the ID of the book to return
     * @throws IllegalArgumentException if the book is not currently loaned
     */
    public void returnBook(long bookId) {
        BookStatus status = bookClient.getBookStatus(bookId);
        if (status != BookStatus.LOANED) {
            throw new IllegalArgumentException("Book with id " + bookId + " is not loaned");
        }
        bookClient.updateBookStatus(bookId, BookStatus.AVAILABLE);
    }
}
