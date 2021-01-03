package com.pattana.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
import com.pattana.model.Address;
import com.pattana.model.Customer;
import com.pattana.repositories.CustomerRepository;
import com.pattana.services.PhotoService;
import com.pattana.services.SequenceGeneratorService;
import com.pattana.utils.datetime.DateUtil;



@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
    @Autowired
    private PhotoService photoService;

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long CustomerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(CustomerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerId));
		return ResponseEntity.ok().body(customer);
	}

	@PostMapping("/customer")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		customer.setId(sequenceGeneratorService.generateSequence(Customer.SEQUENCE_NAME));
		return customerRepository.save(customer);
	}
	
	@PostMapping("/createcustomer")
	public Customer createCustomers(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("emailId") String emailId,
			@RequestParam("title") String title,
			@RequestParam("thaiName") String thaiName,
			@RequestParam("thaiLastName") String thaiLastName,
			@RequestParam("nickName") String nickName,
			@RequestParam("middleName") String middleName,
			@RequestParam("birthDate") String birthDate,
			@RequestParam("country") String country,
			@RequestParam("mobile") String mobile,
			@RequestParam("groupType") String groupType,
			@RequestParam("imageUrl") String imageUrl,
			@RequestParam("status") String status,
			@RequestParam("remarks") String remarks,
			@RequestParam("homeNo") String homeNo,
			@RequestParam("homefloor") String homefloor,
			@RequestParam("soi") String soi,
			@RequestParam("street") String street,
			@RequestParam("district") String district,
			@RequestParam("amphoe") String amphoe,
			@RequestParam("province") String province,
			@RequestParam("zipcode") String zipcode
			) {
	
		Customer customer=new Customer();
		customer.setId(sequenceGeneratorService.generateSequence(Customer.SEQUENCE_NAME));
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmailId(emailId);
		customer.setTitle(title);
		customer.setThaiName(thaiName);
		customer.setThaiLastName(thaiLastName);
		customer.setNickName(nickName);
		customer.setMiddleName(middleName);
		customer.setCountry(country);
		customer.setMobile(mobile);
		customer.setGroupType(groupType);
		customer.setImageUrl(imageUrl);
		customer.setStatus(status);
		customer.setRemarks(remarks);		
		customer.setBirthDate(DateUtil.getStringToDate(birthDate));//input dd/mm/yyyy(CE)
		String birthYear="";
		if(birthDate!=null && birthDate.trim().length()==10) {
			birthYear=birthDate.substring(6, 10);
		}
		customer.setBirthYear(birthYear);
		
		//Address
		Address address=new Address();
		address.setHomeNo(homeNo);
		address.setHomefloor(homefloor);
		address.setSoi(soi);
		address.setStreet(street);
		address.setDistrict(district);
		address.setAmphoe(amphoe);
		address.setProvince(province);
		address.setZipcode(zipcode);
		
		customer.setAddress(address);
		
		return customerRepository.save(customer);
	}
	
	@PostMapping("/createcustomerimage")
	public Customer createCustomerImage(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("emailId") String emailId,
			@RequestParam("title") String title,
			@RequestParam("thaiName") String thaiName,
			@RequestParam("thaiLastName") String thaiLastName,
			@RequestParam("nickName") String nickName,
			@RequestParam("middleName") String middleName,
			@RequestParam("birthDate") String birthDate,
			@RequestParam("country") String country,
			@RequestParam("mobile") String mobile,
			@RequestParam("status") String status,
			@RequestParam("remarks") String remarks,
			@RequestParam("homeNo") String homeNo,
			@RequestParam("homefloor") String homefloor,
			@RequestParam("soi") String soi,
			@RequestParam("street") String street,
			@RequestParam("district") String district,
			@RequestParam("amphoe") String amphoe,
			@RequestParam("province") String province,
			@RequestParam("zipcode") String zipcode,
			@RequestParam("topic") String topic,
			@RequestParam("image") MultipartFile file, 
			@RequestParam("groupType") String groupType,
			@RequestParam("seqSec") int seqSec,
			HttpServletRequest request) {
		System.out.println("Start createCustomerImage() ");
		
		String albumId="";		
		
		Customer customer=new Customer();
		customer.setId(sequenceGeneratorService.generateSequence(Customer.SEQUENCE_NAME));
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmailId(emailId);
		customer.setTitle(title);
		customer.setThaiName(thaiName);
		customer.setThaiLastName(thaiLastName);
		customer.setNickName(nickName);
		customer.setMiddleName(middleName);
		customer.setCountry(country);
		customer.setMobile(mobile);
		customer.setGroupType(groupType);
		customer.setStatus(status);
		customer.setRemarks(remarks);		
		customer.setBirthDate(DateUtil.getStringToDate(birthDate));//input dd/mm/yyyy(CE)
		String birthYear="";
		if(birthDate!=null && birthDate.trim().length()==10) {
			birthYear=birthDate.substring(6, 10);
		}
		customer.setBirthYear(birthYear);
		
		//Address
		Address address=new Address();
		address.setHomeNo(homeNo);
		address.setHomefloor(homefloor);
		address.setSoi(soi);
		address.setStreet(street);
		address.setDistrict(district);
		address.setAmphoe(amphoe);
		address.setProvince(province);
		address.setZipcode(zipcode);
		
		customer.setAddress(address);
		
		customer=customerRepository.save(customer);
		
		if(customer!=null) {
			albumId=String.valueOf(customer.getId());
		}//if
		System.out.println("createCustomerImage#Photo albumId=>"+albumId);
		
    	try {
			String id = photoService.createPhoto(topic,groupType,seqSec,albumId,file,request);
			
			System.out.println("createCustomerImage#Photo id=>"+id);
			
			
			customer.setImageUrl("http://"+request.getServerName()+":"+request.getServerPort()+"/api/v1/file/"+id);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("customer.getImageUrl()=> "+customer.getImageUrl());
		customer=customerRepository.save(customer);
		System.out.println("Finish createCustomerImage() ");
		return customer;
    	
		
	}

	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long CustomerId,
			@Valid @RequestBody Customer CustomerDetails) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(CustomerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerId));

		customer.setEmailId(CustomerDetails.getEmailId());
		customer.setLastName(CustomerDetails.getLastName());
		customer.setFirstName(CustomerDetails.getFirstName());
		final Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}

	@DeleteMapping("/customer/{id}")
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long CustomerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(CustomerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerId));

		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
