package com.pattana.controllers;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

import com.pattana.security.SHA512Hasher;
import com.pattana.exceptions.ResourceNotFoundException;
import com.pattana.model.Role;
import com.pattana.model.User;
import com.pattana.repositories.RoleRepository;
import com.pattana.repositories.UserRepository;

import com.pattana.services.SequenceGeneratorService;
import com.pattana.utils.datetime.DateUtil;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	private   SHA512Hasher hasher;
	private   SecureRandom secureRandom;		

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUsersById(@PathVariable(value = "id") String UsersId)
			throws ResourceNotFoundException {
		User customer = userRepository.findById(UsersId)
				.orElseThrow(() -> new ResourceNotFoundException("Users not found for this id :: " + UsersId));
		return ResponseEntity.ok().body(customer);
	}

	@PostMapping("/user")
	public User createUser(@Valid @RequestBody User user) {
		user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
		
		if(user.getPassWord()!=null && user.getPassWord().trim().length()>0) {
		    hasher = new SHA512Hasher();
		    secureRandom = new SecureRandom();
		    byte[] salt = new byte[16];
		    secureRandom.nextBytes(salt);
		    String hashPassWord = hasher.hash(user.getPassWord(), salt);
			user.setPassWord(hashPassWord);
		}//if
		if(user.getPinId()!=null && user.getPinId().trim().length()>0) {
		    hasher = new SHA512Hasher();
		    secureRandom = new SecureRandom();
		    byte[] salt = new byte[16];
		    secureRandom.nextBytes(salt);
		    String hashPinId = hasher.hash(user.getPinId(), salt);
		    user.setPinId(hashPinId);
		}//if

		user.setCreatedDate(new Date());
		user.setUpdatedDate(new Date());
		user.setDateSystem(DateUtil.getStrDateTime());

		if(user.getRoleName()!=null && (user.getRoleName().equalsIgnoreCase("ADMIN") || user.getRoleName().equalsIgnoreCase("USER"))){
		    Role userRole = roleRepository.findByRole(user.getRoleName());
		    user.setRoles(new HashSet<>(Arrays.asList(userRole)));		
		}	
		
		return userRepository.save(user);
	}
	

	@PostMapping("/createuser")
	public User createUsers(@RequestParam("emailId") String emailId,
			@RequestParam("userName") String userName,
			@RequestParam("passWord") String passWord,
			@RequestParam("pinId") String pinId,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("idCard") String idCard,
			@RequestParam("groupType") String groupType,
			@RequestParam("startDate") String startDate,
			@RequestParam("expiredDate") String expiredDate,
			@RequestParam("status") String status,
			@RequestParam("remarks") String remarks,
			@RequestParam("roleName") String roleName,
			@RequestParam("enabled") boolean enabled
			
			) {

		User user=new User();
		user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));	
		user.setEmailId(emailId);
		user.setUserName(userName);
		if(passWord!=null && passWord.trim().length()>0) {
		    hasher = new SHA512Hasher();
		    secureRandom = new SecureRandom();
		    byte[] salt = new byte[16];
		    secureRandom.nextBytes(salt);
		    String hashPassWord = hasher.hash(passWord, salt);
			user.setPassWord(hashPassWord);
		}//if
		if(pinId!=null && pinId.trim().length()>0) {
		    hasher = new SHA512Hasher();
		    secureRandom = new SecureRandom();
		    byte[] salt = new byte[16];
		    secureRandom.nextBytes(salt);
		    String hashPinId = hasher.hash(pinId, salt);
		    user.setPinId(hashPinId);
		}//if
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setIdCard(idCard);
		user.setGroupType(groupType);
		user.setStartDate(DateUtil.getStringToDate(startDate));
		user.setExpiredDate(DateUtil.getStringToDate(expiredDate));
		user.setStatus(status);
		user.setRemarks(remarks);
		user.setEnabled(enabled);
		user.setCreatedDate(new Date());
		user.setUpdatedDate(new Date());
		user.setRoleName(roleName);
		user.setDateSystem(DateUtil.getStrDateTime());

		if(roleName!=null && (roleName.equalsIgnoreCase("ADMIN") || roleName.equalsIgnoreCase("USER"))){
		    Role userRole = roleRepository.findByRole(roleName);
		    user.setRoles(new HashSet<>(Arrays.asList(userRole)));		
		}				
		
		return userRepository.save(user);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") String UsersId,

			@Valid @RequestBody User UsersDetails) throws ResourceNotFoundException {
		User user = userRepository.findById(UsersId)
				.orElseThrow(() -> new ResourceNotFoundException("Users not found for this id :: " + UsersId));

		/*
		 * user.setFullname(UsersDetails.getFullname());
		 * user.setEmail(UsersDetails.getEmail());
		 * user.setPassword(UsersDetails.getPassword());
		 */
		final User updatedUsers = userRepository.save(user);
		return ResponseEntity.ok(updatedUsers);
	}

	@DeleteMapping("/user/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") String UsersId)
			throws ResourceNotFoundException {
		User user = userRepository.findById(UsersId)
				.orElseThrow(() -> new ResourceNotFoundException("Users not found for this id :: " + UsersId));

		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
