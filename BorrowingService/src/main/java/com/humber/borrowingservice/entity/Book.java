package com.humber.borrowingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class for Book in the borrowing service.
 * <p>
 * This class represents a book with properties like id, title, author, genre, description and status.
 * It uses Lombok annotations for boilerplate code reduction.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private long id;
    private String title;
    private String author;
    private String genre;
    private String description;
    private BookStatus status;
}
