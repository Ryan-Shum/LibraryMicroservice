package com.humber.borrowingservice.controller;

import com.humber.borrowingservice.client.BookClient;
import com.humber.borrowingservice.entity.Book;
import com.humber.borrowingservice.service.BorrowingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("borrow")
public class BorrowController {
    private final BookClient borrowClient;
    private final BorrowingService borrowingService;

    //get all books
    @GetMapping("/booklist")
    public List<Book> getBooks(){
       return borrowClient.getBooks();
    }

    //borrow a book
    @PostMapping("/book/{bookId}/borrow")
    public ResponseEntity<String> borrowBook(@PathVariable long bookId) {
        try {
            borrowingService.borrowBook(bookId);
            return new ResponseEntity<>("Book borrowed successfully", HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //return a book
    @PostMapping("/book/{bookId}/return")
    public ResponseEntity<String> returnBook(@PathVariable long bookId) {
        try {
            borrowingService.returnBook(bookId);
            return new ResponseEntity<>("Book returned successfully", HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
