package com.humber.bookservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class for Book.
 *
 * This class represents a book with properties like id, title, author, genre, description and status.
 * It uses Lombok annotations for boilerplate code reduction.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String description;
    @Enumerated(EnumType.STRING)
    private BookStatus status;
}
