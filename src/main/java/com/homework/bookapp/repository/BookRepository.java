package com.homework.bookapp.repository;

import com.homework.bookapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;



@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByBarcode(String barcode);


}
