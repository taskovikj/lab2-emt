package com.example.bookstore2.sevices.impl;

import com.example.bookstore2.model.Country;
import com.example.bookstore2.repositority.CountryRepositority;
import com.example.bookstore2.sevices.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepositority countryRepositority;

    public CountryServiceImpl(CountryRepositority countryRepositority) {
        this.countryRepositority = countryRepositority;
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepositority.findAll();
    }

    @Override
    public Optional<Country> create(String name, String continent) {
        Country obj = new Country(name,continent);
        return Optional.of( this.countryRepositority.save(obj));
    }

    @Override
    public void delete(Long id) {

        this.countryRepositority.deleteById(id);
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.findById(id);
    }

    @Override
    public Optional<Country> update(Long id, String name, String continent) {
        Country obj = this.countryRepositority.findById(id).orElseThrow(RuntimeException::new);
        obj.setName(name);
        obj.setContinent(continent);
        this.countryRepositority.save(obj) ;
        return Optional.of(obj);

    }
}
