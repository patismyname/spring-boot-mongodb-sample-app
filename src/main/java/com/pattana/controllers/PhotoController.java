package com.pattana.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pattana.model.Photo;
import com.pattana.services.PhotoService;
import com.pattana.utils.MD5Util;


//@Controller
@RestController
@RequestMapping("/api/v1")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/photos/{id}")
    public String getPhoto(@PathVariable String id, Model model) {
        Photo photo = photoService.getPhoto(id);
        model.addAttribute("topic", photo.getTopic());
        model.addAttribute("image", Base64.getEncoder().encodeToString(photo.getContent().getData()));
        
        //System.out.println("image=>"+model.getAttribute("image"));
        
        return "photos";
    }
    
	@GetMapping("/file/{id}")
	@ResponseBody
	public ResponseEntity<Object> saveFile(@PathVariable String id) throws UnsupportedEncodingException {

		Optional<Photo> file = photoService.getFileById(id);

		if (file!=null && file.isPresent()) {
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + new String(file.get().getName().getBytes("utf-8"),"ISO-8859-1"))
					.header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
					.header(HttpHeaders.CONTENT_LENGTH, file.get().getSize() + "").header("Connection", "close")
					.body(file.get().getContent().getData());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File was not fount");
		}

	}

    @GetMapping("/photos/upload")
    public String uploadPhoto(Model model) {
        model.addAttribute("message", "hello");
        return "uploadPhoto";
    }

    @PostMapping("/photos/createphoto")
    public String addPhoto(@RequestParam("title") String title, @RequestParam("image") MultipartFile file, @RequestParam("groupType") String groupType,@RequestParam("seqSec") int seqSec,HttpServletRequest request) throws IOException {
   
        System.out.println("getContextPath()=>"+request.getContextPath());
        System.out.println("getRemoteAddr()=>"+request.getRemoteAddr());
        System.out.println("getRemoteHost()=>"+request.getRemoteHost());
        System.out.println("getLocalAddr()=>"+request.getLocalAddr());
        System.out.println("getServletPath()=>"+request.getServletPath());
        System.out.println("getServerName()=>"+request.getServerName());
        System.out.println("getServerPort()=>"+request.getServerPort());
        System.out.println("getRequestURI()=>"+request.getRequestURI());
        System.out.println("getSession()=>"+request.getSession());
        
        
    	String id = photoService.addPhoto(title, file,groupType,seqSec,request);
        return "redirect:/photos/" + id;
    }
    

    @PostMapping("/photos/addnew")
    public String addPhoto(@RequestParam("title") String title, @RequestParam("image") MultipartFile image, Model model) throws IOException {
        String id = photoService.addNewPhoto(title, image);
        return "redirect:/photos/" + id;
    }
    
    
	@PostMapping("/upload")
	@ResponseBody
	public ResponseEntity<String> handleFileUpload(@RequestParam("title") String title,@RequestParam("image") MultipartFile file) {
		Photo returnFile = null;
		try {
			Photo f = new Photo(title,file.getOriginalFilename(), file.getContentType(), file.getSize(),
					new Binary(file.getBytes()));
			f.setMd5(MD5Util.getMD5(file.getInputStream()));
			returnFile = photoService.saveFile(f);
			String path = "http://192.168.56.1:8080/files/" + returnFile.getId();
			return ResponseEntity.status(HttpStatus.OK).body(path);

		} catch (IOException | NoSuchAlgorithmException ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

	}
}
