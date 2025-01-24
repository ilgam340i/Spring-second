package ru.vagapov.spring.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name ="books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private BigDecimal price;
    @Column
    private Date rentDate;
    @Column
    private Date returnDate;
    @Column
    private Boolean returned;
    @Column
    private Long timesOfRental;

    public BookEntity() {
    }

    public BookEntity(Long id, String title, BigDecimal price, String author, Date rentDate, Date returnDate, Boolean returned, Long timesOfRental) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
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
