package com.example.bookstore2.repositority;

import com.example.bookstore2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositority extends JpaRepository<Book,Long> {
}
