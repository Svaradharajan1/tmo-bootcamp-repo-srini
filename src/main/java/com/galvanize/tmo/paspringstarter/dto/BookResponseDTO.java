package com.galvanize.tmo.paspringstarter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.galvanize.tmo.paspringstarter.entity.Book;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookResponseDTO implements Serializable {

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
