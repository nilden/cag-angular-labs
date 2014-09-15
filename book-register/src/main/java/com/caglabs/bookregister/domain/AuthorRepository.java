package com.caglabs.bookregister.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "authors", path = "authors")
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

    List<Author> findBySurname(@Param("surname") String surname);
}
