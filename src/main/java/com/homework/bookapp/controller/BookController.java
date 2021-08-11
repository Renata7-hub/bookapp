package com.homework.bookapp.controller;


import com.homework.bookapp.model.Book;
import com.homework.bookapp.model.BookDTO;
import com.homework.bookapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RequestMapping(value = "/book")
@RestController
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book>  bookRegistration(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity(bookService.bookRegistration(bookDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{barcode}")
    public ResponseEntity<Book> getBookByBarcode(@PathVariable String barcode) {
        if (bookService.findBookByBarcode(barcode) != null)
            return new ResponseEntity(bookService.findBookByBarcode(barcode), HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{barcode}")
    public ResponseEntity<Book> updateBookByBarcode(@PathVariable String barcode, @RequestBody BookDTO bookDTO) {
        if (bookService.findBookByBarcode(barcode) != null)
            return new ResponseEntity(bookService.updateBookByBarcode(barcode, bookDTO), HttpStatus.OK);
        else
            return new ResponseEntity(bookService.bookRegistration(bookDTO), HttpStatus.CREATED);
    }

    @GetMapping("/price/{barcode}")
    public ResponseEntity<Book> getBookTotalPriceByBarcode(@PathVariable String barcode) {
        if (bookService.findBookByBarcode(barcode) != null)
            return new ResponseEntity(bookService.getBooksTotalPriceByBarcode(barcode), HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/quantity")
    public Map<String, Integer> getBooksByQuantity() {
        return bookService.getAllBooksBarcodesByQuantity();
    }

}
