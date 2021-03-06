package com.galvanize.tmo.paspringstarter;

import com.galvanize.tmo.paspringstarter.dto.BookDTO;
import com.galvanize.tmo.paspringstarter.dto.BookResponseDTO;
import com.galvanize.tmo.paspringstarter.entity.Book;
import com.galvanize.tmo.paspringstarter.impl.LibraryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {

    private final Logger logger = LoggerFactory.getLogger(LibraryController.class);

    private LibraryServiceImpl libraryService;

    @Autowired
    public LibraryController(LibraryServiceImpl libraryService)
    {
        this.libraryService = libraryService;
    }

    @GetMapping("/health")
    public void health() {
    }

    @PostMapping(value = "/api/books")
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO)
    {
        logger.info(">> addBook():");
        BookDTO book = libraryService.addBook(bookDTO);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/books")
    public ResponseEntity<BookResponseDTO> listBooks()
    {
        logger.info(">> listBooks():");
        List<BookDTO> books = libraryService.listAllBooks();
        BookResponseDTO bookResponseDTO = new BookResponseDTO();
        bookResponseDTO.setBooks(books);
        return new ResponseEntity<>(bookResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/books")
    public ResponseEntity<?> deleteBooks()
    {
        logger.info(">> deleteBooks():");
        libraryService.deleteBooks();
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
