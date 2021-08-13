//package com.homework.bookapp.service;
//
//
//import com.homework.bookapp.BookappApplicationTests;
//import com.homework.bookapp.model.Book;
//
//import com.homework.bookapp.repository.BookRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.*;
//
//
//@RunWith(SpringRunner.class)
//public class BookServiceTest extends BookappApplicationTests {
//
//    @InjectMocks
//    public BookService bookService;
//
//    @Mock
//    public BookRepository bookRepository;
//
//    @Test
//    void getAllBooks() {
//        Book book = new Book();
//        Book book1 = new Book();
//        book.setId(1L);
//        book1.setId(2L);
//        List<Book>expectedBooks = new ArrayList<>();
//        expectedBooks.add(book);
//        expectedBooks.add(book1);
//
//        Mockito.when(this.bookRepository.findAll().thenReturn(expectedBooks));
//        List<Book>books = bookService.getAllBooks();
//
//        assertThat(books).isEqualTo(expectedBooks);
//    }
//}
