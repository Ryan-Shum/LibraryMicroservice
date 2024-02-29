package com.humber.borrowingservice.controller;

import com.humber.borrowingservice.client.BookClient;
import com.humber.borrowingservice.entity.Book;
import com.humber.borrowingservice.service.BorrowingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing book borrowings.
 *
 * This class handles HTTP requests related to borrowing and returning books.
 */
@RestController
@AllArgsConstructor
@RequestMapping("borrow")
public class BorrowController {
    private final BookClient borrowClient;
    private final BorrowingService borrowingService;

    /**
     * Endpoint to get all books.
     *
     * @return a list of all books
     */
    @GetMapping("/booklist")
    public List<Book> getBooks(){
       return borrowClient.getBooks();
    }

    /**
     * Endpoint to borrow a book.
     *
     * @param bookId the ID of the book to borrow
     * @return a ResponseEntity with a message and HTTP status OK if the book was borrowed successfully,
     *         or a ResponseEntity with an error message and HTTP status BAD_REQUEST if an error occurred
     */
    @PostMapping("/book/{bookId}/borrow")
    public ResponseEntity<String> borrowBook(@PathVariable long bookId) {
        try {
            borrowingService.borrowBook(bookId);
            return new ResponseEntity<>("Book borrowed successfully", HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Endpoint to return a book.
     *
     * @param bookId the ID of the book to return
     * @return a ResponseEntity with a message and HTTP status OK if the book was returned successfully,
     *         or a ResponseEntity with an error message and HTTP status BAD_REQUEST if an error occurred
     */
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
