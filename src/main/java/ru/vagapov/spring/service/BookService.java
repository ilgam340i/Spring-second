package ru.vagapov.spring.service;

import ru.vagapov.spring.dto.Book;

import java.util.List;

public interface BookService {

    Book findBookById(Long id);
    List<Book> findAllBooks();
    void updateBook(Book book);


}
