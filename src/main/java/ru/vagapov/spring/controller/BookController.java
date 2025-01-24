package ru.vagapov.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vagapov.spring.dto.Book;
import ru.vagapov.spring.mapper.BookMapper;
import ru.vagapov.spring.service.BookService;
import ru.vagapov.spring.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final UserService userService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, BookService bookService1, UserService userService, BookMapper bookMapper) {
        this.bookService = bookService1;
        this.userService = userService;
        this.bookMapper = bookMapper;
    }


    @GetMapping
    public String Home (Model model) {
        List<Book> bookList = bookService.findAllBooks();
        model.addAttribute("books", bookList);
        return "books";
    }


}
