package com.humber.borrowingservice.service;

import com.humber.borrowingservice.client.BookClient;
import com.humber.borrowingservice.entity.BookStatus;
import org.springframework.stereotype.Service;

@Service
public class BorrowingService {
    private final BookClient bookClient;

    public BorrowingService(BookClient bookClient) {
        this.bookClient = bookClient;
    }

    //Method to borrow a book
    //Checks if the book is available and updates the status to loaned
    public void borrowBook(long bookId) {
        BookStatus status = bookClient.getBookStatus(bookId);
        if (status != BookStatus.AVAILABLE) {
            throw new IllegalArgumentException("Book with id " + bookId + " is unavailable for borrowing");
        }
        bookClient.updateBookStatus(bookId, BookStatus.LOANED);
    }

    //Method to return a book
    //Checks if the book is loaned and updates the status to available
    public void returnBook(long bookId) {
        BookStatus status = bookClient.getBookStatus(bookId);
        if (status != BookStatus.LOANED) {
            throw new IllegalArgumentException("Book with id " + bookId + " is not loaned");
        }
        bookClient.updateBookStatus(bookId, BookStatus.AVAILABLE);
    }
}
