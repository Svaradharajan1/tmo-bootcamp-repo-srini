package com.galvanize.tmo.paspringstarter.util;

import com.galvanize.tmo.paspringstarter.dto.BookDTO;
import com.galvanize.tmo.paspringstarter.entity.Book;

public class LibraryUtil {

    public static Book getBookEntityFromBookDTO(BookDTO bookDTO)
    {
        Book book = new Book();
        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());
        book.setYearPublished(bookDTO.getYearPublished());
        return book;
    }
}
