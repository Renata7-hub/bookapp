package com.homework.bookapp.repository;

import com.homework.bookapp.model.AncientBook;
import com.homework.bookapp.model.Book;
import com.homework.bookapp.model.ScienceJournal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AncientBookRepository extends JpaRepository<AncientBook,Long> {


 //   ScienceJournal findAncientBookByBook(Book bookByBarcode);//
}
