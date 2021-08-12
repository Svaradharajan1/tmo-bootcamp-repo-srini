package com.galvanize.tmo.paspringstarter.service;

import com.galvanize.tmo.paspringstarter.dto.BookDTO;
import com.galvanize.tmo.paspringstarter.entity.Book;
import com.galvanize.tmo.paspringstarter.impl.LibraryServiceImpl;
import com.galvanize.tmo.paspringstarter.repo.BookRepository;
import org.assertj.core.api.Assertions;
import org.hibernate.annotations.ManyToAny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith({ MockitoExtension.class })
public class LibraryServiceTest {

    @Mock
    private BookRepository bookRepository;

    private LibraryServiceImpl libraryService;

    @BeforeEach
    public void setUp()
    {
        libraryService = new LibraryServiceImpl(bookRepository);
    }

    @Test
    public void addBookTest()
    {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthor("ABC");
        bookDTO.setTitle("XYZ");
        bookDTO.setYearPublished(1234);
        Assertions.assertThatCode(() -> libraryService.addBook(bookDTO)).doesNotThrowAnyException();
    }

    @Test
    public void listBookTest()
    {
        Assertions.assertThatCode(() -> libraryService.listAllBooks()).doesNotThrowAnyException();
    }

    @Test
    public void deleteBookTest()
    {
        Assertions.assertThatCode(() -> libraryService.deleteBooks()).doesNotThrowAnyException();
    }
}
