package com.solwin.test.controller;

import java.io.IOException;
import java.math.BigInteger;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.solwin.test.entity.ClassSchedule;
import com.solwin.test.service.IClassScheduleService;
import com.solwin.test.structures.Schedule;

@RestController
@RequestMapping("/")
public class ClassScheduleController {
	@Autowired
	private IClassScheduleService classScheduleService;

	@GetMapping("/class/{id}")
	public ResponseEntity<ClassSchedule> getClassScheduleById(@PathVariable("id") BigInteger id) {
		return new ResponseEntity<ClassSchedule>(classScheduleService.getClassScheduleById(id), HttpStatus.OK);
	}
	
	@GetMapping("/classes/{jsonParams}")
	public ResponseEntity<List<ClassSchedule>> getPaymentsByDateRange(@PathVariable("jsonParams") String sJSONSchedule) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return new ResponseEntity<List<ClassSchedule>>(
				  	classScheduleService
						.getClassSchedulesByParams(
								mapper.readValue(sJSONSchedule, Schedule.class)), 
						        HttpStatus.OK);
	}
	
	@PostMapping("/class")
	public ResponseEntity<Void> addClassSchedule(@RequestBody ClassSchedule classSchedule, UriComponentsBuilder builder) {
        if (!classScheduleService.addClassSchedule(classSchedule)) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/class/{id}").buildAndExpand(classSchedule.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/class")
	public ResponseEntity<ClassSchedule> updateUser(@RequestBody ClassSchedule payment) {
		// TODO Check if user exists by Id
		classScheduleService.updateClassSchedule(payment);
		return new ResponseEntity<ClassSchedule>(payment, HttpStatus.OK);
	}
	
	@DeleteMapping("/class/{id}")
	public ResponseEntity<Void> deleteClassSchedule(@PathVariable("id") BigInteger id) {
		classScheduleService.deleteClassSchedule(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}