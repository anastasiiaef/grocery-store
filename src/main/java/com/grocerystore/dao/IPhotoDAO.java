package com.grocerystore.dao;

import org.springframework.web.multipart.MultipartFile;

import com.grocerystore.dto.PhotoDTO;

public interface IPhotoDAO {

	void savePhotoImage(PhotoDTO photoDTO, MultipartFile imageFile) throws Exception;

	void save(PhotoDTO photoDTO);

}