package com.pattana.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pattana.exceptions.ResourceNotFoundException;
import com.pattana.model.Review;
import com.pattana.repositories.ReviewRepository;
import com.pattana.services.PhotoService;
import com.pattana.services.SequenceGeneratorService;
import com.pattana.utils.datetime.DateUtil;

@RestController
@RequestMapping("/api/v1")
public class ReviewController {
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private PhotoService photoService;
    
	@GetMapping("/reviews")
	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}
	
	@GetMapping("/reviewbytitle/{id}")
	public List<Review> getReviewByTitleRegexQuery(@PathVariable(value = "id") int titleId) {
		return reviewRepository.getReviewByTitleRegexQuery(titleId);
	}
	

	@GetMapping("/review/{id}")
	public ResponseEntity<Review> getReviewById(@PathVariable(value = "id") Long reviewId)
			throws ResourceNotFoundException {
		Review review = reviewRepository.findById(reviewId)
				.orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + reviewId));
		return ResponseEntity.ok().body(review);
	}

	@PostMapping("/review")
	public Review createReview(@Valid @RequestBody Review review) {
		review.setId(sequenceGeneratorService.generateSequence(Review.SEQUENCE_NAME));
		
		return reviewRepository.save(review);
	}
	
	@PostMapping("/createreview")
	public Review createReview(@RequestParam("groupType") String groupType,
			@RequestParam("titleName") String titleName,
			@RequestParam("titleId") int titleId,
			@RequestParam("comments") String comments,
			@RequestParam("reviewedBy") String reviewedBy,
			@RequestParam("userId") int userId,
			@RequestParam("updatedBy") String updatedBy,
			@RequestParam("status") String status,
			@RequestParam("remarks") String remarks,
			@RequestParam("starMarks") int starMarks,
			@RequestParam("image") MultipartFile file, 
			@RequestParam("seqSec") int seqSec,
			HttpServletRequest request
			) {
		
		Review review=new Review();
		review.setId(sequenceGeneratorService.generateSequence(Review.SEQUENCE_NAME));
		review.setGroupType(groupType);
		review.setTitleName(titleName);
		review.setTitleId(titleId);
		review.setComments(comments);
		review.setReviewedBy(reviewedBy);
		review.setUserId(userId);
		review.setReviewedDate(new Date());
		review.setUpdatedBy(updatedBy);
		review.setStatus(status);
		review.setRemarks(remarks);
		review.setStarMarks(starMarks);
		review=reviewRepository.save(review);
		
		String albumId="";
		
		if(review!=null) {
			albumId=String.valueOf(review.getId());
		}//if
		System.out.println("createReview#Photo albumId=>"+albumId);
		
    	try {
			String id = photoService.createPhoto(titleName,groupType,seqSec,albumId,file,request);
			
			System.out.println("createReview#Photo id=>"+id);			
			
			review.setImageUrl("http://"+request.getServerName()+":"+request.getServerPort()+"/api/v1/file/"+id);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	review=reviewRepository.save(review);
		
		return review;
	}

	@PutMapping("/review/{id}")
	public ResponseEntity<Review> updateReview(@PathVariable(value = "id") Long reviewId,
			@Valid @RequestBody Review reviewReq) throws ResourceNotFoundException {
		Review review = reviewRepository.findById(reviewId)
				.orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + reviewId));

		review.setTitleName(reviewReq.getTitleName());
		review.setGroupType(reviewReq.getGroupType());
		review.setComments(reviewReq.getComments());
		final Review updatedReview = reviewRepository.save(review);
		return ResponseEntity.ok(updatedReview);
	}

	@DeleteMapping("/review/{id}")
	public Map<String, Boolean> deleteReview(@PathVariable(value = "id") Long reviewId)
			throws ResourceNotFoundException {
		Review review = reviewRepository.findById(reviewId)
				.orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + reviewId));

		reviewRepository.delete(review);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
