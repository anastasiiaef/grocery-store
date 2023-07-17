package com.grocerystore.dao;

import org.springframework.data.repository.CrudRepository;

import com.grocerystore.dto.PhotoDTO;

public interface PhotoRepository extends CrudRepository<PhotoDTO, Integer> {

}
