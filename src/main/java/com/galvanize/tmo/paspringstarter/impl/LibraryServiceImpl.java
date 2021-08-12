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
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class LibraryServiceImpl implements LibraryService {

    private final Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);

    private BookRepository bookRepository;

    private List<BookDTO> bookDTOList = new ArrayList<>();
    private Integer id=0;

    @Autowired
    public LibraryServiceImpl(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        logger.info(">> addBook()");

//        List<Book> books = bookRepository.findAll();
//        Book book = LibraryUtil.getBookEntityFromBookDTO(bookDTO);
//        if (!CollectionUtils.isEmpty(books)) {
//            books.sort(Comparator.comparing(Book::getId));
//            book.setId(books.get(books.size() - 1).getId() + 1);
//        }
        id++;
        bookDTO.setId(id);
        bookDTOList.add(bookDTO);
        return bookDTO;
    }

    @Override
    public List<BookDTO> listAllBooks() {
        logger.info(">> listAllBooks()");
        bookDTOList.sort(Comparator.comparing(BookDTO::getTitle));
        return bookDTOList;
    }

    @Override
    public void deleteBooks() {
        logger.info(">> deleteBooks()");
        bookDTOList.clear();
        id=0;
        logger.info("-- deleteBooks(): deleted all books.");
    }
}
