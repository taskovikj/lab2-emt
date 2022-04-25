package com.example.bookstore2.model.DTO;

import com.example.bookstore2.model.Author;
import com.example.bookstore2.model.Category;


import java.util.List;

public class BookDTO {
    private String name;

    private Category category;

    private List<Author> author;

    private Integer availableCopies;

    public BookDTO(String name, Category category, List<Author> author, Integer availableCopies) {
        this.name = name;

        this.category = category;

        this.author = author;

        this.availableCopies = availableCopies;
    }
}
