package com.assignment3.catalogue.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.assignment3.catalogue.entities.TitleAndAuthor;

public interface TitleAndAuthorRepository extends MongoRepository<TitleAndAuthor, String> {

	@Query(value = "{ '$or' : [ {'Title' : {$regex : ?0, $options: 'i'}}, {'Author' : {$regex : ?1, $options: 'i'}}] }")
	List<TitleAndAuthor> findByTitlesOrAuthorLike(String title, String author);

}
