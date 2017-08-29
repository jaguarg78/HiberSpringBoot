package com.solwin.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solwin.test.entity.ClassStatus;
import com.solwin.test.service.IClassStatusService;

@RestController
@RequestMapping("/")
public class ClassStatusController {
	@Autowired
	private IClassStatusService classStatusService;
	
	@GetMapping("/classStatus/{id}")
	public ResponseEntity<ClassStatus> getClassStatusById(@PathVariable("id") Integer id) {
		return new ResponseEntity<ClassStatus>(classStatusService.getClassStatusById(id), HttpStatus.OK);
	}
	
	@GetMapping("/classStatus")
	public ResponseEntity<List<ClassStatus>> getAllClassStatus() {
		return new ResponseEntity<List<ClassStatus>>(classStatusService.getAllClassStatus(), HttpStatus.OK);
	}
}
