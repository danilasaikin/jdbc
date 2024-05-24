package com.example.jdbc.repo;

import com.example.jdbc.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
