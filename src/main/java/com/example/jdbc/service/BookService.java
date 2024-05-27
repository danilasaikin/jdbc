package com.example.jdbc.service;

import com.example.jdbc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> findAll() {
        String query = "SELECT * FROM books";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Book.class));
    }

    public Book findById(Long id) {
        String query = "SELECT * FROM books WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }

    public Book save(Book book) {
        String query = "INSERT INTO books (title, author, publicationYear) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, book.getTitle(), book.getAuthor(), book.getPublicationYear());
        return book;
    }

    public boolean deleteById(Long id) {
        String query = "DELETE FROM books WHERE id = ?";
        return jdbcTemplate.update(query, id) > 0;
    }

    public Book update(Book book) {
        String query = "UPDATE books SET title = ?, author = ?, publicationYear = ? WHERE id = ?";
        jdbcTemplate.update(query, book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getId());
        return book;
    }
}
