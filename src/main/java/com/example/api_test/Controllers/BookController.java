package com.example.api_test.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_test.Domain.Book;
import com.example.api_test.Services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService service;

    public BookController(BookService service){
        this.service = service;
    }

    @GetMapping("")
    public  ResponseEntity<List<Book>> getBooks(){
        List<Book> books = service.getBooksFromLibrary(); 

        if (books == null || books.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(books);
    }
}
