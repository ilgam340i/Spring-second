package ru.vagapov.spring.service.Impl;

import org.springframework.stereotype.Service;
import ru.vagapov.spring.dto.Book;
import ru.vagapov.spring.entity.BookEntity;
import ru.vagapov.spring.mapper.BookMapper;
import ru.vagapov.spring.repository.BookQantityRepository;
import ru.vagapov.spring.repository.BookRepository;
import ru.vagapov.spring.service.BookService;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
   private final BookRepository bookRepository;
   private final BookMapper bookMapper;
   private final BookQantityRepository bookQantityRepository;
   public BookServiceImpl(BookRepository bookRepository, BookQantityRepository bookQantityRepository, BookMapper bookMapper) {
       this.bookRepository = bookRepository;
       this.bookQantityRepository = bookQantityRepository;
       this.bookMapper = bookMapper;
   }

    @Override
    public Book findBookById(Long id) {
        return bookMapper.BookEntitytoBookDto(bookRepository.findById(id).get());
    }

    @Override
    public List<Book> findAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return bookMapper.ListOfBookEntitytoListOfBookDto(bookEntities);
    }

    @Override
    public void updateBook(Book book) {
       BookEntity bookEntity = bookMapper.BookDtotoBookEntity(book);
       bookRepository.save(bookEntity);
    }

}
