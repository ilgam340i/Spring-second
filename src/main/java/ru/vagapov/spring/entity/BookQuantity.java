package ru.vagapov.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book_quantity")
public class BookQuantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private Long quantity;
    @Column
    private Long rentedQuantity;
    @Column
    private Long totalQuantity;

    public BookQuantity() {};
    public BookQuantity(String title, Long quantity, Long rentedQuantity, Long totalQuantity) {
        this.title = title;
        this.quantity = quantity;
        this.rentedQuantity = rentedQuantity;
        this.totalQuantity = totalQuantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getRentedQuantity() {
        return rentedQuantity;
    }

    public void setRentedQuantity(Long rentedQuantity) {
        this.rentedQuantity = rentedQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getTotalQuantity() {
        return totalQuantity;
    }
    public void setTotalQuantity(Long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
