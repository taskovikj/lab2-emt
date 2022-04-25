package com.example.bookstore2.sevices;

import com.example.bookstore2.model.Country;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface CountryService {
    List<Country> listAll();

    Optional<Country> create(String name, String continent);

    void delete(Long id);

    Optional<Country> findById(Long id);

    Optional<Country> update(Long id,String name, String continent);
}
