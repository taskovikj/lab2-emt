package com.example.bookstore2.sevices.impl;

import com.example.bookstore2.extentions.InvalidAuthorIdException;
import com.example.bookstore2.model.Author;
import com.example.bookstore2.model.Country;
import com.example.bookstore2.repositority.AuthorRepositority;
import com.example.bookstore2.sevices.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepositority authorRepositority;

    public AuthorServiceImpl(AuthorRepositority authorRepositority) {
        this.authorRepositority = authorRepositority;
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepositority.findAll();
    }

    @Override
    public Optional<Author> create(String name, String surname, Country country) {
        Author obj = new Author(name,surname,country);
        return Optional.of( this.authorRepositority.save(obj));
    }

    @Override
    public void delete(Long id) {
        this.authorRepositority.deleteById(id);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.of( this.authorRepositority.findById(id).orElseThrow(InvalidAuthorIdException::new));
    }

    @Override
    public Optional<Author> update(Long id, String name, String surname, Country country) {
        Author obj = this.findById(id).orElseThrow(InvalidAuthorIdException::new);
        obj.setCountry(country);
        obj.setName(name);
        obj.setSurname(surname);
        this.authorRepositority.save(obj);
        return Optional.of(obj);
    }
}
