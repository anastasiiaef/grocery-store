package com.grocerystore.dao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.grocerystore.dto.PhotoDTO;

@Component
public class PhotoDAO implements IPhotoDAO {
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Override
	public void savePhotoImage(PhotoDTO photoDTO, MultipartFile imageFile) throws Exception {
	//gets us to src/main/resources without knowing the full path		
	Path currentPath = Paths.get(".");
	Path absolutePath = currentPath.toAbsolutePath();
	photoDTO.setPath(absolutePath + "/src/main/resources/static/photos/");
	byte[] bytes = imageFile.getBytes();
	Path path = Paths.get(photoDTO.getPath() + imageFile.getOriginalFilename());		
	Files.write(path, bytes);
	}

	@Override
	public void save(PhotoDTO photoDTO) {
		photoRepository.save(photoDTO);
	}
}
