package com.pattana.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pattana.model.Photo;
import com.pattana.repositories.PhotoRepository;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepo;

    public Photo getPhoto(String id) {
        return photoRepo.findById(id).get();
    }

	public Optional<Photo> getFileById(String id) {
		return photoRepo.findById(id);
	}
	
	public Photo saveFile(Photo file) {
		return photoRepo.save(file);
	}

    public String addPhoto(String topic, MultipartFile file,String groupType,int seqSec,HttpServletRequest request) throws IOException {
    	
    	Photo photo = new Photo(topic,file.getOriginalFilename(), file.getContentType(), file.getSize(),
				new Binary(file.getBytes()));
    	
        //photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));     
        photo.setGroupType(groupType);
        photo.setSeqSec(seqSec);
                
        photo = photoRepo.insert(photo);
        
        photo.setAlbumId("");
        photo.setThumbnailUrl("http://"+request.getServerName()+":"+request.getServerPort()+"/api/v1/file/"+photo.getId());
        photo.setUrl("http://"+request.getServerName()+":"+request.getServerPort()+"/api/v1/photos/"+photo.getId());
        photo.setStatus("Active");
        photo.setDesc("topic:"+topic+" filename:"+file.getOriginalFilename()+" content type:"+ file.getContentType()+" size:"+ file.getSize());
        photo.setCreatedBy("pattana.k");
        photo.setId(photo.getId());
        
       // System.out.println("photo.getId()=>"+photo.getId());
        
        photo = photoRepo.save(photo);
        
        return photo.getId();
    }
    
    public String createPhoto(String topic,String groupType,int seqSec,String albumId, MultipartFile file,HttpServletRequest request) throws IOException {
    	
    	Photo photo = new Photo(topic,file.getOriginalFilename(), file.getContentType(), file.getSize(),
				new Binary(file.getBytes()));
    	
        //photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));     
        photo.setGroupType(groupType);
        photo.setSeqSec(seqSec);
                
        photo = photoRepo.insert(photo);
        
        System.out.println("createPhoto#photo albumId=>"+albumId);
        photo.setAlbumId(albumId);
        photo.setThumbnailUrl("http://"+request.getServerName()+":"+request.getServerPort()+"/api/v1/file/"+photo.getId());
        photo.setUrl("http://"+request.getServerName()+":"+request.getServerPort()+"/api/v1/photos/"+photo.getId());
        photo.setStatus("Active");
        photo.setDesc("topic:"+topic+" filename:"+file.getOriginalFilename()+" content type:"+ file.getContentType()+" size:"+ file.getSize());
        photo.setCreatedBy("pattana.k");
        photo.setId(photo.getId());
        
       // System.out.println("createPhoto#photo.getId()=>"+photo.getId());
        
        photo = photoRepo.save(photo);
        
        return photo.getId();
    }
    
    public String addNewPhoto(String topic, MultipartFile file) throws IOException {
    	
        Photo photo = new Photo(topic,file.getOriginalFilename(), file.getContentType(), file.getSize(),
				new Binary(file.getBytes()));
        //photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));       
                
        photo = photoRepo.insert(photo);
        
        photo.setAlbumId("1");
        photo.setThumbnailUrl("http://localhost:8080/api/v1/file/"+photo.getId());
        photo.setUrl("http://localhost:8080/api/v1/photos/"+photo.getId());
        photo.setStatus("Active");
        photo.setDesc("topic:"+topic+" filename:"+file.getOriginalFilename()+" content type:"+ file.getContentType()+" size:"+ file.getSize());
        photo.setCreatedBy("pattana.k");
        photo.setId(photo.getId());
        
       // System.out.println("photo.getId()=>"+photo.getId());
        
        photo = photoRepo.save(photo);
        
        return photo.getId();
    }
    
	public List<Photo> findAll() {
		List<Photo> list = null;
		
		list = photoRepo.findAll();

		return list;
	}
    
	public List<Photo> listFilesByPage(int pageIndex, int pageSize) {
		Page<Photo> page = null;
		List<Photo> list = null;
		
		Sort sort = new Sort(Direction.DESC,"uploadDate"); 
		Pageable pageable = PageRequest.of(pageIndex, pageSize, sort);
		
		page = photoRepo.findAll(pageable);
		list = page.getContent();
		return list;
	}
    
	
}
