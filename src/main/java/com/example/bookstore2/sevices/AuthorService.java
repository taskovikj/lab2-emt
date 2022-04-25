package com.example.bookstore2.sevices;

import com.example.bookstore2.model.Author;
import com.example.bookstore2.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface AuthorService {
    List<Author> listAll();

    Optional<Author> create(String name, String surname, Country country);

    void delete(Long id);

    Optional<Author> findById(Long id);

    Optional<Author> update(Long id,String name, String surname, Country country);
}
