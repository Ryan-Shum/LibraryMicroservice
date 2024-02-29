package com.humber.bookservice.repository;

import com.humber.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repository interface for managing books.
 * <p>
 * This interface extends JpaRepository, which provides methods for CRUD operations.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
