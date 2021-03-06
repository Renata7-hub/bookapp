package com.homework.bookapp.service;

import com.homework.bookapp.model.Book;
import com.homework.bookapp.model.BookDTO;
import com.homework.bookapp.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    public boolean barcodeExist(String barcode) {
//        boolean barcodeNotExist = bookRepository.findBookByBarcode(barcode).();
//        boolean barcodeExist = !barcodeNotExist;
//        return true;
//    }

    public Book bookRegistration(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setBarcode(bookDTO.getBarcode());
        book.setQuantity(bookDTO.getQuantity());
        book.setPricePerUnit(bookDTO.getPricePerUnit());
        bookRepository.save(book);
        return book;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBookByBarcode(String barcode, BookDTO bookDTO) {
        Book updatedBook = bookRepository.findBookByBarcode(barcode);
        updatedBook.setTitle(bookDTO.getTitle());
        updatedBook.setAuthor(bookDTO.getAuthor());
        updatedBook.setQuantity(bookDTO.getQuantity());
        updatedBook.setPricePerUnit(bookDTO.getPricePerUnit());
        bookRepository.save(updatedBook);
        return updatedBook;
    }

    public Book findBookByBarcode(String barcode) {
        return bookRepository.findBookByBarcode(barcode);
    }

    public String getBooksTotalPriceByBarcode(String barcode) {
    BigDecimal totalPrice = null;
        //double totalPrice;
        Book book = bookRepository.findBookByBarcode(barcode);
      /*       if (book.getScienceIndex != null || book.getScienceIndex.isEmpty ) {
             totalPrice = new BigDecimal(book.getPricePerUnit() * book.getQuantity()*book.getScienceIndex());
         } else if (book.getReleaseYear != null || book.getScienceIndex.isEmpty) {
             LocalDate localDate = LocalDate.now();
             int currentYear = localDate.getYear();
             totalPrice = new BigDecimal(book.getPricePerUnit() * book.getQuantity()
             * (currentYear-book.getReleaseYear)/3);
         } else {
        */
        totalPrice = new BigDecimal(book.getPricePerUnit() * book.getQuantity());
        double totalPriceD= totalPrice.doubleValue();
        double totalPriceRound = Math.round(totalPriceD*100.0) / 100.0;
       //totalPrice = Math.round(new BigDecimal(book.getPricePerUnit() * book.getQuantity()).doubleValue()*100.0)/100.0;
        return "Total price = " + totalPriceRound + ", when barcode = " + barcode;
    }

    public Map<String, Integer> getAllBooksBarcodesByQuantity() {
        return bookRepository.findAll().stream()
                .sorted(Comparator.comparing(Book::getQuantity))
                .collect(Collectors.toMap(Book::getBarcode, Book::getQuantity, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
