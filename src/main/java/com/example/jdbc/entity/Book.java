package com.example.jdbc.entity;


import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@Table(name = "books")
public class Book {
    @Id
    private Long id;
    private String title;
    private String author;
    private int publicationYear;
}
