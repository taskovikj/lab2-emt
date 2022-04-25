package com.example.bookstore2.sevices.impl;

import com.example.bookstore2.extentions.InvalidBookIdException;
import com.example.bookstore2.model.Author;
import com.example.bookstore2.model.Book;
import com.example.bookstore2.model.Category;
import com.example.bookstore2.model.Country;
import com.example.bookstore2.repositority.BookRepositority;
import com.example.bookstore2.sevices.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepositority bookRepositority;

    public BookServiceImpl(BookRepositority bookRepositority) {
        this.bookRepositority = bookRepositority;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepositority.findAll();
    }

    @Override
    public Optional<Book> create(String name, Category category, List<Author> author, Integer availableCopies) {
        Book obj = new Book(name,category,author,availableCopies);
        return Optional.of( this.bookRepositority.save(obj));
    }

    @Override
    public void delete(Long id) {
        this.bookRepositority.deleteById(id);
    }

    @Override
    public Optional<Book> findById(Long id) {

        return Optional.of( this.bookRepositority.findById(id).orElseThrow(InvalidBookIdException::new));
    }

    @Override
    public Optional<Book> update(Long id, String name, Category category, List<Author> author, Integer availableCopies) {
        Book obj = this.findById(id).orElseThrow(InvalidBookIdException::new);
        obj.setAuthor(author);
        obj.setCategory(category);
        obj.setName(name);
        obj.setAvailableCopies(availableCopies);
        this.bookRepositority.save(obj);
        return Optional.of(obj);
    }

    @Override
    public Book taken(Long id) {
        return null;
    }
}
