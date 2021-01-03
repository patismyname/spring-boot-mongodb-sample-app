package com.pattana.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pattana.exceptions.ResourceNotFoundException;
import com.pattana.model.Posts;
import com.pattana.repositories.PostsRepository;
import com.pattana.services.SequenceGeneratorService;

@RestController
@RequestMapping("/api/v1")
public class PostsController {
	@Autowired
	private PostsRepository postsRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/posts")
	public List<Posts> getAllPosts() {
		return postsRepository.findAll();
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<Posts> getPostsById(@PathVariable(value = "id") Long PostsId)
			throws ResourceNotFoundException {
		Posts posts = postsRepository.findById(PostsId)
				.orElseThrow(() -> new ResourceNotFoundException("Posts not found for this id :: " + PostsId));
		return ResponseEntity.ok().body(posts);
	}

	@PostMapping("/posts")
	public Posts createPosts(@Valid @RequestBody Posts posts) {
		posts.setId(sequenceGeneratorService.generateSequence(Posts.SEQUENCE_NAME));
		
		return postsRepository.save(posts);
	}

	@PutMapping("/posts/{id}")
	public ResponseEntity<Posts> updatePosts(@PathVariable(value = "id") Long PostsId,
			@Valid @RequestBody Posts PostsDetails) throws ResourceNotFoundException {
		Posts posts = postsRepository.findById(PostsId)
				.orElseThrow(() -> new ResourceNotFoundException("Posts not found for this id :: " + PostsId));

		posts.setUserId(PostsDetails.getUserId());
		posts.setTitle(PostsDetails.getTitle());
		posts.setBody(PostsDetails.getBody());
		final Posts updatedPosts = postsRepository.save(posts);
		return ResponseEntity.ok(updatedPosts);
	}

	@DeleteMapping("/posts/{id}")
	public Map<String, Boolean> deletePosts(@PathVariable(value = "id") Long PostsId)
			throws ResourceNotFoundException {
		Posts posts = postsRepository.findById(PostsId)
				.orElseThrow(() -> new ResourceNotFoundException("Posts not found for this id :: " + PostsId));

		postsRepository.delete(posts);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
