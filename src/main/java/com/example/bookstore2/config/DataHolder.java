package com.example.bookstore2.config;

import com.example.bookstore2.model.Author;
import com.example.bookstore2.model.Book;
import com.example.bookstore2.model.Country;
import com.example.bookstore2.sevices.AuthorService;
import com.example.bookstore2.sevices.impl.BookServiceImpl;
import com.example.bookstore2.sevices.impl.CountryServiceImpl;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.bookstore2.model.Category.NOVEL;
import static com.example.bookstore2.model.Category.THRILER;

@Component
@Getter
public class DataHolder {
    private final AuthorService authorService;
    private final BookServiceImpl bookService;
    private final CountryServiceImpl countryService;



    List<Country> countryList = new ArrayList<>();
    List<Book> bookList = new ArrayList<>();
    List<Author> authorList = new ArrayList<>();

    public DataHolder(AuthorService authorService, BookServiceImpl bookService, CountryServiceImpl countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }


    @PostConstruct
    void initData(){

        this.countryService.create("Country 1", "Continent 1");
        this.countryService.create("Country 2", "Continent 2");
        this.countryService.create("Country 3", "Continent 3");
        this.countryService.create("Country 4", "Continent 4");
        countryList = this.countryService.listAll();
        this.authorService.create("Author 1", "Surname 1", countryList.get(0));
        this.authorService.create("Author 2", "Surname 2", countryList.get(0));
        this.authorService.create("Author 2", "Surname 2", countryList.get(2));
        this.authorService.create("Author 2", "Surname 2", countryList.get(1));
        this.authorService.create("Author 2", "Surname 2", countryList.get(2));
        authorList = this.authorService.listAll();
        this.bookService.create("Novel 1", NOVEL, authorList, 31);
        this.bookService.create("Novel 2", NOVEL, authorList, 12);
        this.bookService.create("THRILER 1", THRILER, authorList, 22);
        this.bookService.create("THRILER 2", THRILER, authorList, 11);
    }
}

