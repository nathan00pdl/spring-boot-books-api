package com.example.api_test.Services;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.List;
import com.example.api_test.Domain.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private static final String BOOKS_FILE = "books.json";

    ObjectMapper objectMapper = new ObjectMapper();

    public List<Book> getBooksFromLibrary() {
        // reading from the classpath works on any machine and inside the packaged jar
        try (InputStream books = new ClassPathResource(BOOKS_FILE).getInputStream()) {
            return objectMapper.readValue(books, new TypeReference<List<Book>>() {});
        } catch (IOException e) {
            throw new UncheckedIOException("Não foi possível ler " + BOOKS_FILE + " do classpath", e);
        }
    }
}
