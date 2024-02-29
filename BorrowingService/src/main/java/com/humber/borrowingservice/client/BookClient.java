package com.humber.borrowingservice.client;

import com.humber.borrowingservice.entity.Book;
import com.humber.borrowingservice.entity.BookStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("book-service")
public interface BookClient {

    //returns all books from book service
    @GetMapping("/books/list")
    List<Book> getBooks();

    //updates the status of a book using book service endpoint
    @PutMapping("/books/{id}/status")
    void updateBookStatus(@PathVariable("id") Long id, @RequestBody BookStatus status);

    @GetMapping("/books/{id}/status")
    BookStatus getBookStatus(@PathVariable("id") Long id);
}
