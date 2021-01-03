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
import com.pattana.model.Advertisement;
import com.pattana.repositories.AdvertisementRepository;
import com.pattana.services.PhotoService;
import com.pattana.services.SequenceGeneratorService;
import com.pattana.utils.datetime.DateUtil;

@RestController
@RequestMapping("/api/v1")
public class AdvertisementController {
	@Autowired
	private AdvertisementRepository advertisementRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private PhotoService photoService;
    
	@GetMapping("/advertisements")
	public List<Advertisement> getAllAdvertisements() {
		return advertisementRepository.findAll();
	}

	@GetMapping("/advertisement/{id}")
	public ResponseEntity<Advertisement> getAdvertisementById(@PathVariable(value = "id") Long advertisementId)
			throws ResourceNotFoundException {
		Advertisement advertisement = advertisementRepository.findById(advertisementId)
				.orElseThrow(() -> new ResourceNotFoundException("Advertisement not found for this id :: " + advertisementId));
		return ResponseEntity.ok().body(advertisement);
	}

	@PostMapping("/advertisement")
	public Advertisement createAdvertisement(@Valid @RequestBody Advertisement advertisement) {
		advertisement.setId(sequenceGeneratorService.generateSequence(Advertisement.SEQUENCE_NAME));
		
		return advertisementRepository.save(advertisement);
	}
	
	@PostMapping("/createadvertisement")
	public Advertisement createAdvertisement(@RequestParam("topicTitle") String topicTitle,
			@RequestParam("msgDetails") String msgDetails,
			@RequestParam("startOnlineDate") String startOnlineDate,
			@RequestParam("finishOnlineDate") String finishOnlineDate,
			@RequestParam("vdoUrl") String vdoUrl,
			@RequestParam("groupType") String groupType,
			@RequestParam("updatedBy") String updatedBy,
			@RequestParam("status") String status,
			@RequestParam("remarks") String remarks,
			@RequestParam("image") MultipartFile file, 
			@RequestParam("seqSec") int seqSec,
			HttpServletRequest request
			) {
		
		Advertisement advertisement=new Advertisement();
		advertisement.setId(sequenceGeneratorService.generateSequence(Advertisement.SEQUENCE_NAME));
		advertisement.setTopicTitle(topicTitle);
		advertisement.setMsgDetails(msgDetails);
		advertisement.setStartOnlineDate(DateUtil.getStringToDate(startOnlineDate));
		advertisement.setFinishOnlineDate(DateUtil.getStringToDate(finishOnlineDate));
		advertisement.setVdoUrl(vdoUrl);
		advertisement.setCreatedDate(new Date());
		advertisement.setUpdatedDate(new Date());
		advertisement.setUpdatedBy(updatedBy);
		advertisement.setStatus(status);
		advertisement.setRemarks(remarks);
		
		advertisement=advertisementRepository.save(advertisement);
		
		String albumId="";
		
		if(advertisement!=null) {
			albumId=String.valueOf(advertisement.getId());
		}//if
		System.out.println("createAdvertisement#Photo albumId=>"+albumId);
		
    	try {
			String id = photoService.createPhoto(topicTitle,groupType,seqSec,albumId,file,request);
			
			System.out.println("createAdvertisement#Photo id=>"+id);			
			
			advertisement.setImageUrl("http://"+request.getServerName()+":"+request.getServerPort()+"/api/v1/file/"+id);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	advertisement=advertisementRepository.save(advertisement);
		
		return advertisement;
	}

	@PutMapping("/advertisement/{id}")
	public ResponseEntity<Advertisement> updateAdvertisement(@PathVariable(value = "id") Long advertisementId,
			@Valid @RequestBody Advertisement advertisementReq) throws ResourceNotFoundException {
		Advertisement advertisement = advertisementRepository.findById(advertisementId)
				.orElseThrow(() -> new ResourceNotFoundException("Advertisement not found for this id :: " + advertisementId));

		advertisement.setTopicTitle(advertisementReq.getTopicTitle());
		advertisement.setGroupType(advertisementReq.getGroupType());
		advertisement.setMsgDetails(advertisementReq.getMsgDetails());
		final Advertisement updatedCourse = advertisementRepository.save(advertisement);
		return ResponseEntity.ok(updatedCourse);
	}

	@DeleteMapping("/advertisement/{id}")
	public Map<String, Boolean> deleteAdvertisement(@PathVariable(value = "id") Long advertisementId)
			throws ResourceNotFoundException {
		Advertisement advertisement = advertisementRepository.findById(advertisementId)
				.orElseThrow(() -> new ResourceNotFoundException("Advertisement not found for this id :: " + advertisementId));

		advertisementRepository.delete(advertisement);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
