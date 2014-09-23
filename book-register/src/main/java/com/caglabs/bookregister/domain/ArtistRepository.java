package com.caglabs.bookregister.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "artists", path = "artists")
public interface ArtistRepository extends PagingAndSortingRepository<Artist, Long> {

}
