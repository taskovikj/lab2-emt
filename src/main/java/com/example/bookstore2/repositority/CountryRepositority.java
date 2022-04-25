package com.example.bookstore2.repositority;

import com.example.bookstore2.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepositority extends JpaRepository<Country,Long> {
}
