package com.solwin.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.solwin.test.entity.ClassType;
import com.solwin.test.service.IClassTypeService;

@RestController
@RequestMapping("/")
public class ClassTypeController {
	@Autowired
	private IClassTypeService classTypeService;
	
	@GetMapping("/classType/{id}")
	public ResponseEntity<ClassType> getClassTypeById(@PathVariable("id") Integer id) {
		return new ResponseEntity<ClassType>(classTypeService.getClassTypeById(id), HttpStatus.OK);
	}
	
	@GetMapping("/classTypes")
	public ResponseEntity<List<ClassType>> getAllClassTypes() {
		return new ResponseEntity<List<ClassType>>(classTypeService.getAllClassTypes(), HttpStatus.OK);
	}
	
	@PostMapping("/classType")
	public ResponseEntity<Void> addClassType(@RequestBody ClassType classType, UriComponentsBuilder builder) {
        if (!classTypeService.addClassType(classType)) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/classType/{id}").buildAndExpand(classType.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/classType")
	public ResponseEntity<ClassType> updateClassType(@RequestBody ClassType classType) {
		// TODO Check if site exists by Id
		classTypeService.updateClassType(classType);
		return new ResponseEntity<ClassType>(classType, HttpStatus.OK);
	}
	
	@DeleteMapping("/classType/{id}")
	public ResponseEntity<Void> deleteClassType(@PathVariable("id") Integer id) {
		classTypeService.deleteClassType(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
