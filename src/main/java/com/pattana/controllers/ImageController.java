package com.pattana.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pattana.exceptions.ResourceNotFoundException;
import com.pattana.model.Image;
import com.pattana.model.Photo;
import com.pattana.repositories.ImageRepository;
import com.pattana.services.PhotoService;
import org.springframework.data.domain.Sort;


@RestController
@RequestMapping("/api/v1")
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;
    
    @Autowired
    private PhotoService photoService;
    

	@GetMapping("/allimages")
	public List<Image> findAll() {
		
		return imageRepository.findAll(Sort.by(Sort.Direction.DESC, "uploadDate"));
	}

	@GetMapping("/images")
	public List<Image> getBySeqSecRegexQuery() {
		int seqSec=1;
		return imageRepository.getBySeqSecRegexQuery(seqSec);
	}

	 @GetMapping("/paramimages/{seqSec}")
	public List<Image> getBySeqSecRegexQuery(@PathVariable int seqSec) {

		return imageRepository.getBySeqSecRegexQuery(seqSec);
	}


	@GetMapping("/image/{id}")
	public ResponseEntity<Image> getImageById(@PathVariable(value = "id") String Id)
			throws ResourceNotFoundException {
		Image image = imageRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Photo not found for this id :: " + Id));
		return ResponseEntity.ok().body(image);
	}


}
