package com.galvanize.tmo.paspringstarter.impl;

import com.galvanize.tmo.paspringstarter.LibraryController;
import com.galvanize.tmo.paspringstarter.api.LibraryService;
import com.galvanize.tmo.paspringstarter.dto.BookDTO;
import com.galvanize.tmo.paspringstarter.entity.Book;
import com.galvanize.tmo.paspringstarter.repo.BookRepository;
import com.galvanize.tmo.paspringstarter.util.LibraryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryServiceImpl implements LibraryService {

    private final Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);

    private BookRepository bookRepository;

    @Autowired
    public LibraryServiceImpl(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(BookDTO bookDTO) {
        logger.info(">> addBook()");
        Book book = LibraryUtil.getBookEntityFromBookDTO(bookDTO);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> listAllBooks() {
        logger.info(">> listAllBooks()");
        return bookRepository.findAll();
    }

    @Override
    public void deleteBooks() {
        logger.info(">> deleteBooks()");
        bookRepository.deleteAll();
        logger.info("-- deleteBooks(): deleted all books.");
    }
}
