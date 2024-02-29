package com.humber.bookservice.controller;

import com.humber.bookservice.entity.Book;
import com.humber.bookservice.entity.BookStatus;
import com.humber.bookservice.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("books")
public class BookController {
    private final BookService bookService;
    @GetMapping("list")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }
    @PutMapping("/{id}/status")
    public ResponseEntity<Book> updateBookStatus(@PathVariable Long id, @RequestBody BookStatus status) {
        Book updatedBook = bookService.updateBookStatus(id, status);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

}
