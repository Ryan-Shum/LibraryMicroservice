package com.humber.bookservice.utils;

import com.humber.bookservice.entity.Book;
import com.humber.bookservice.entity.BookStatus;
import com.humber.bookservice.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DBSeeder implements CommandLineRunner {
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        //Seed the database with 10 books
        List<Book> books = List.of(
                Book.builder().title("Forrest Gump").author("Winston Groom").genre("Comedy-drama").description("The story of a man who, despite his sub-normal IQ, leads an extraordinary life.").status(BookStatus.AVAILABLE).build(),
                Book.builder().title("To Kill a Mockingbird").author("Harper Lee").genre("Classic").description("A novel about the childhood reflections of racism and injustice in the Deep South.").status(BookStatus.LOANED).build(),
                Book.builder().title("1984").author("George Orwell").genre("Dystopian").description("A dystopian novel about the dangers of totalitarianism.").status(BookStatus.RESERVED).build(),
                Book.builder().title("The Great Gatsby").author("F. Scott Fitzgerald").genre("Tragedy").description("A story of the mysteriously wealthy Jay Gatsby and his love for Daisy Buchanan.").status(BookStatus.AVAILABLE).build(),
                Book.builder().title("Pride and Prejudice").author("Jane Austen").genre("Romance").description("The story of Elizabeth Bennet and her journey towards love and self-understanding.").status(BookStatus.AVAILABLE).build(),
                Book.builder().title("The Hobbit").author("J.R.R. Tolkien").genre("Fantasy").description("The adventure of Bilbo Baggins as he encounters dragons and other fantastical creatures.").status(BookStatus.LOANED).build(),
                Book.builder().title("The Catcher in the Rye").author("J.D. Salinger").genre("Coming-of-age").description("A tale of teenage angst and alienation.").status(BookStatus.LOST).build(),
                Book.builder().title("Brave New World").author("Aldous Huxley").genre("Science Fiction").description("A future society where happiness is mandated through conditioning.").status(BookStatus.RESERVED).build(),
                Book.builder().title("The Diary of a Young Girl").author("Anne Frank").genre("Biography").description("The writings from the Dutch language diary kept by Anne Frank while she was in hiding during World War II.").status(BookStatus.LOANED).build(),
                Book.builder().title("Sapiens: A Brief History of Humankind").author("Yuval Noah Harari").genre("Non-fiction").description("A book that explores the history of humankind from the Stone Age to the modern day.").status(BookStatus.LOANED).build()
        );
        bookRepository.saveAll(books);

//        bookRepository.findAll().forEach((book ->
//                System.out.println(book.getId() + " " + book.getTitle() + " " + book.getAuthor() + " " + book.getGenre() + " " + book.getDescription() + " " + book.getStatus())
//        ));
    }

}
