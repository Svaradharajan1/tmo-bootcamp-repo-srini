package com.galvanize.tmo.paspringstarter.repo;

import com.galvanize.tmo.paspringstarter.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends JpaRepository<Book, Integer> {
}
