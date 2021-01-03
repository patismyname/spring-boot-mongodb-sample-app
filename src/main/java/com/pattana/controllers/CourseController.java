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
import com.pattana.model.Course;
import com.pattana.repositories.CourseRepository;
import com.pattana.services.PhotoService;
import com.pattana.services.SequenceGeneratorService;
import com.pattana.utils.datetime.DateUtil;

@RestController
@RequestMapping("/api/v1")
public class CourseController {
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private PhotoService photoService;
    
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable(value = "id") Long CourseId)
			throws ResourceNotFoundException {
		Course course = courseRepository.findById(CourseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + CourseId));
		return ResponseEntity.ok().body(course);
	}
	

	@GetMapping("/paramcourse/{seqSec}")
	public List<Course> getCourseBySeqSec(@PathVariable int seqSec)
			throws ResourceNotFoundException {
		List<Course> listCourse = courseRepository.getCourseBySeqSecRegexQuery(seqSec);
				
		return listCourse;
	}
	

	@PostMapping("/course")
	public Course createCourse(@Valid @RequestBody Course course) {
		course.setId(sequenceGeneratorService.generateSequence(Course.SEQUENCE_NAME));
		
		return courseRepository.save(course);
	}
	
	@PostMapping("/createcourse")
	public Course createCourses(@RequestParam("courseName") String courseName,
			@RequestParam("groupType") String groupType,
			@RequestParam("titleName") String titleName,
			@RequestParam("adsWord") String adsWord,
			@RequestParam("description") String description,
			@RequestParam("hoursTotalNum") int hoursTotalNum,
			@RequestParam("costOfflineBht") double costOfflineBht,
			@RequestParam("startOfflineDate") String startOfflineDate,
			@RequestParam("finishOfflineDate") String finishOfflineDate,
			@RequestParam("startOfflineTime") String startOfflineTime,
			@RequestParam("finishOfflineTime") String finishOfflineTime,
			@RequestParam("costOnlineBht") double costOnlineBht,
			@RequestParam("startOnlineDate") String startOnlineDate,
			@RequestParam("finishOnlineDate") String finishOnlineDate,
			@RequestParam("startOnlineTime") String startOnlineTime,
			@RequestParam("finishOnlineTime") String finishOnlineTime,
			@RequestParam("vdoUrl") String vdoUrl,
			@RequestParam("updatedBy") String updatedBy,
			@RequestParam("status") String status,
			@RequestParam("remarks") String remarks,
			@RequestParam("instructorName") String instructorName,
			@RequestParam("image") MultipartFile file, 
			@RequestParam("seqSec") int seqSec,
			HttpServletRequest request
			) {
		
		Course course=new Course();
		course.setId(sequenceGeneratorService.generateSequence(Course.SEQUENCE_NAME));
		course.setCourseName(courseName);
		course.setGroupType(groupType);
		course.setTitleName(titleName);
		course.setAdsWord(adsWord);
		course.setDescription(description);
		course.setHoursTotalNum(hoursTotalNum);
		course.setCostOfflineBht(costOfflineBht);	
		course.setStartOfflineDate(DateUtil.getStringToDate(startOfflineDate));
		course.setFinishOfflineDate(DateUtil.getStringToDate(finishOfflineDate));
		course.setStartOfflineTime(startOfflineTime);
		course.setFinishOfflineTime(finishOfflineTime);
		course.setCostOnlineBht(costOnlineBht);
		course.setStartOnlineDate(DateUtil.getStringToDate(startOnlineDate));
		course.setFinishOnlineDate(DateUtil.getStringToDate(finishOnlineDate));
		course.setStartOnlineTime(startOnlineTime);
		course.setFinishOnlineTime(finishOnlineTime);
		course.setVdoUrl(vdoUrl);
		course.setCreatedDate(new Date());
		course.setUpdatedDate(new Date());
		course.setUpdatedBy(updatedBy);
		course.setStatus(status);
		course.setRemarks(remarks);
		course.setInstructorName(instructorName);
		course.setSeqSec(seqSec);
		
		course=courseRepository.save(course);
		
		String albumId="";
		
		if(course!=null) {
			albumId=String.valueOf(course.getId());
		}//if
		System.out.println("createCourses#Photo albumId=>"+albumId);
		
    	try {
			String id = photoService.createPhoto(titleName,groupType,seqSec,albumId,file,request);
			
			System.out.println("createCourses#Photo id=>"+id);			
			
			course.setImageUrl("http://"+request.getServerName()+":"+request.getServerPort()+"/api/v1/file/"+id);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	course=courseRepository.save(course);
		
		return course;
	}

	@PutMapping("/course/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") Long CourseId,
			@Valid @RequestBody Course CourseDetails) throws ResourceNotFoundException {
		Course course = courseRepository.findById(CourseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + CourseId));

		course.setCourseName(CourseDetails.getCourseName());
		course.setGroupType(CourseDetails.getGroupType());
		course.setTitleName(CourseDetails.getTitleName());
		final Course updatedCourse = courseRepository.save(course);
		return ResponseEntity.ok(updatedCourse);
	}

	@DeleteMapping("/course/{id}")
	public Map<String, Boolean> deleteCourse(@PathVariable(value = "id") Long CourseId)
			throws ResourceNotFoundException {
		Course course = courseRepository.findById(CourseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + CourseId));

		courseRepository.delete(course);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
