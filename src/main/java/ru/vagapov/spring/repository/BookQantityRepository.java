package ru.vagapov.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vagapov.spring.entity.BookQuantity;

import java.util.Optional;

@Repository
public interface BookQantityRepository extends JpaRepository<BookQuantity,Long> {
    Optional<BookQuantity> findByTitle (String title);

}
