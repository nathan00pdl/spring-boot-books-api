# Books API — Spring Boot

[![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)](https://openjdk.org/projects/jdk/17/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.10-6DB33F?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/github/license/nathan00pdl/spring-boot-books-api)](LICENSE)

A REST API that serves a list of programming books read from a local JSON file.

This was my first API built from scratch, following [this video](https://www.youtube.com/watch?v=MuF_jkfdqUo) by Fernanda Kipper. In the video the book data comes from AWS; I chose to keep it local, so the project stays about the API itself — the layers, the dependency injection and the JSON serialization — with nothing else to set up.

## Tech stack

- **Java 17**
- **Spring Boot 3.2.10** — Spring Web
- **Jackson** for reading the JSON into Java objects
- **Lombok** for the constructors
- **Maven**, through the Maven Wrapper (`./mvnw`)

## How it works

| Class | Responsibility |
|---|---|
| `Book` | The domain object: title, author, area, cover image, publisher, release date, year and ISBN |
| `BookService` | Reads `books.json` from the classpath and turns it into a `List<Book>` with Jackson's `ObjectMapper` |
| `BookController` | Exposes the endpoint, receives the service through constructor injection, and chooses the response status |

The data lives in `src/main/resources/books.json`. Reading it from the classpath is what makes the project run anywhere, including from the packaged jar.

## Endpoint

| Method | Path | Response |
|---|---|---|
| `GET` | `/api/books` | **200** with the list of books · **204** when the list is empty |

```bash
curl http://localhost:8080/api/books
```

```json
[
  {
    "titulo": "Clean Code",
    "autor": "Robert C. Martin",
    "area": "Desenvolvimento de Software",
    "imagem": "https://images-na.ssl-images-amazon.com/images/I/41xShlnTZTL._SX374_BO1,204,203,200_.jpg",
    "editora": "Prentice Hall",
    "data_de_lancamento": "11 de agosto de 2008",
    "ano_de_publicacao": "2008",
    "isbn": "978-0132350884"
  }
]
```

The field names are in Portuguese because they mirror the JSON file as it is.

## Running locally

Requirements: **Java 17**. Maven does not need to be installed.

```bash
git clone https://github.com/nathan00pdl/spring-boot-books-api.git
cd spring-boot-books-api
./mvnw spring-boot:run
```

The API starts on `http://localhost:8080`. To add or change books, edit `src/main/resources/books.json` and restart.

## License

Licensed under the [MIT License](LICENSE).

## Contact

Nathan Paiva de Lacerda — [LinkedIn](https://www.linkedin.com/in/nathan-paiva-636336236)
