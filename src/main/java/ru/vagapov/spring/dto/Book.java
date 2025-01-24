package ru.vagapov.spring.dto;

import java.math.BigDecimal;
import java.util.Date;
/**
 * Модель книги, используется для уменьшения запросов к БД у слоя бизнес-логики
 */
public class Book {
    private Long id;
    private String title;
    private String author;
    private BigDecimal price;
    private Date rentDate;
    private Date returnDate;
    private Long rentQuantity;
    private Boolean returned;
    private Long timesOfRental;

    public Book() {};
    public Book(Long id, String title, BigDecimal price, String author, Date rentDate, Date returnDate, Long rentQuantity, Boolean returned, Long timesOfRental) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.rentQuantity = rentQuantity;
        this.returned = returned;
        this.timesOfRental = timesOfRental;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Long getRentQuantity() {
        return rentQuantity;
    }

    public void setRentQuantity(Long rentQuantity) {
        this.rentQuantity = rentQuantity;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }

    public Long getTimesOfRental() {
        return timesOfRental;
    }

    public void setTimesOfRental(Long timesOfRental) {
        this.timesOfRental = timesOfRental;
    }
}
