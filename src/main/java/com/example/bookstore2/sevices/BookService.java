package com.example.bookstore2.sevices;

import com.example.bookstore2.model.Author;
import com.example.bookstore2.model.Book;
import com.example.bookstore2.model.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();

   Optional<Book> create(String name, Category category, List<Author> author, Integer availableCopies);

    void delete(Long id);

    Optional<Book> findById(Long id);

    Optional<Book> update(Long id,String name, Category category, List<Author> author, Integer availableCopies);

    Book taken(Long id);
}
