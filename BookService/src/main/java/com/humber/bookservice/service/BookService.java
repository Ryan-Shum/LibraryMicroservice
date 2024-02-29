package com.humber.bookservice.service;

import com.humber.bookservice.entity.Book;
import com.humber.bookservice.entity.BookStatus;
import com.humber.bookservice.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @Transactional
    public Book updateBookStatus(Long bookId, BookStatus newStatus) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book with id " + bookId + " not found"));
        book.setStatus(newStatus);
        return bookRepository.save(book);
    }

}
