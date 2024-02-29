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

    public void borrowBook(long bookId) {
        bookClient.updateBookStatus(bookId, BookStatus.LOANED);
    }

    public void returnBook(long bookId) {
        bookClient.updateBookStatus(bookId, BookStatus.AVAILABLE);
    }
}
