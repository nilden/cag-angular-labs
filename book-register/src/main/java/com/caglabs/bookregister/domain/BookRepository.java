package com.caglabs.bookregister.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    List<Book> findByTitle(@Param("title") String title);

    Book findByIsbn(@Param("isbn") String isbn);

    @Query("SELECT book FROM Book book, Author a WHERE a MEMBER OF book.authors AND a.forename LIKE %:name%")
    List<Book> findBooksForAuthorWithForenameLike(@Param("name") String name);
}
