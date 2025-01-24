package ru.vagapov.spring.mapper;

import org.springframework.stereotype.Component;
import ru.vagapov.spring.dto.Book;
import ru.vagapov.spring.entity.BookEntity;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookMapper {

        public Book BookEntitytoBookDto(BookEntity bookEntity) {
            Book bookDto = new Book();
            bookDto.setId(bookEntity.getId());
            bookDto.setTitle(bookEntity.getTitle());
            bookDto.setAuthor(bookEntity.getAuthor());
            bookDto.setPrice(bookEntity.getPrice());
            bookDto.setReturned(bookEntity.getReturned());
            bookDto.setRentDate(bookEntity.getRentDate());
            bookDto.setReturnDate(bookEntity.getReturnDate());
            bookDto.setTimesOfRental(bookEntity.getTimesOfRental());
            return bookDto;
        }

        public BookEntity BookDtotoBookEntity(Book book) {
            BookEntity bookDto = new BookEntity();
            bookDto.setId(book.getId());
            bookDto.setTitle(book.getTitle());
            bookDto.setAuthor(book.getAuthor());
            bookDto.setPrice(book.getPrice());
            bookDto.setReturned(book.getReturned());
            bookDto.setRentDate(book.getRentDate());
            bookDto.setReturnDate(book.getReturnDate());
            bookDto.setTimesOfRental(book.getTimesOfRental());
            return bookDto;
        }

        public List<Book> ListOfBookEntitytoListOfBookDto(List<BookEntity> bookEntityList) {
            List<Book> bookDtoList = new ArrayList<>();
            for (BookEntity bookEntity : bookEntityList) {
                bookDtoList.add(BookEntitytoBookDto(bookEntity));
            }
            return bookDtoList;
        }

        public List<BookEntity> ListOfBookDtotoListOfBookEntity(List<Book> bookDtoList) {
            List<BookEntity> bookEntityList = new ArrayList<>();
            for (Book bookDto : bookDtoList) {
                bookEntityList.add(BookDtotoBookEntity(bookDto));
            }
            return bookEntityList;
        }
}
