package com.galvanize.tmo.paspringstarter.api;

import com.galvanize.tmo.paspringstarter.dto.BookDTO;
import com.galvanize.tmo.paspringstarter.entity.Book;

import java.util.List;

public interface LibraryService {

    BookDTO addBook(BookDTO book);

    List<BookDTO> listAllBooks();

    void deleteBooks();

}
