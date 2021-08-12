package com.homework.bookapp.service;

import com.homework.bookapp.model.AncientBook;
import com.homework.bookapp.model.AncientBookDTO;
import com.homework.bookapp.model.Book;
import com.homework.bookapp.model.ScienceJournal;
import com.homework.bookapp.repository.AncientBookRepository;
import com.homework.bookapp.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AncientBookService {
    private final AncientBookRepository ancientBookRepository;
    private final BookRepository bookRepository;

    public AncientBookService(AncientBookRepository ancientBookRepository, BookRepository bookRepository) {
        this.ancientBookRepository = ancientBookRepository;
        this.bookRepository = bookRepository;
    }

    public AncientBook ancientBookRegistration(AncientBookDTO ancientBookDTO) {
        AncientBook ancientBook = new AncientBook();
        ancientBook.setBook(ancientBookDTO.getBook());
        ancientBook.setReleaseYear(ancientBookDTO.getReleaseYear());
        ancientBookRepository.save(ancientBook);
        return ancientBook;
    }

    public List<AncientBook> getAllAncientBooks() {
        return ancientBookRepository.findAll();
    }

   /* public AncientBook findAncientBookByBarcode(String barcode) {

        return ancientBookRepository.findAncientBookByBook(bookRepository.findBookByBarcode(barcode));

    }*/

    /*public AncientBook updateAncientBookByBarcode(String barcode, AncientBookDTO ancientBookDTO) {
        AncientBook ancientBook = ancientBookRepository
                .findAncientBookByBook(bookRepository.findBookByBarcode(barcode));
        updatedAncientBook.setBook(ancientBookDTO.getBook());
        updatedAncientBook.getReleaseYear(ancientBookDTO.getReleaseYear());
        updatedAncientBook.save(updatedAncientBook);
        return updatedAncientBook;
    }*/
}
