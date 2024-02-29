package com.humber.borrowingservice.client;

import com.humber.borrowingservice.entity.Book;
import com.humber.borrowingservice.entity.BookStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Feign client interface for communicating with the book-service.
 *
 * This interface defines methods for fetching all books, updating the status of a book,
 * and getting the status of a book. These methods correspond to endpoints in the book-service.
 */
@FeignClient("book-service")
public interface BookClient {

    /**
     * Fetches all books from the book-service.
     *
     * @return a list of all books
     */
    @GetMapping("/books/list")
    List<Book> getBooks();

    /**
     * Updates the status of a book in the book-service.
     *
     * @param id the ID of the book
     * @param status the new status to set
     */
    @PutMapping("/books/{id}/status")
    void updateBookStatus(@PathVariable("id") Long id, @RequestBody BookStatus status);

    /**
     * Fetches the status of a book in the book-service.
     *
     * @param id the ID of the book
     * @return the status of the book
     */
    @GetMapping("/books/{id}/status")
    BookStatus getBookStatus(@PathVariable("id") Long id);
}
