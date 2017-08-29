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

import com.solwin.test.entity.Place;
import com.solwin.test.service.IPlaceService;

@RestController
@RequestMapping("/")
public class PlaceController {
	@Autowired
	private IPlaceService placeService;
	
	@GetMapping("/place/{id}")
	public ResponseEntity<Place> getPlaceById(@PathVariable("id") int id) {
		return new ResponseEntity<Place>(placeService.getPlaceById(id), HttpStatus.OK);
	}
	
	@GetMapping("/places")
	public ResponseEntity<List<Place>> getAllPlaces() {
		return new ResponseEntity<List<Place>>(placeService.getAllPlaces(), HttpStatus.OK);
	}
	
	@PostMapping("/place")
	public ResponseEntity<Void> addPlace(@RequestBody Place place, UriComponentsBuilder builder) {
        if (!placeService.addPlace(place)) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/place/{id}").buildAndExpand(place.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/place")
	public ResponseEntity<Place> updatePlace(@RequestBody Place place) {
		// TODO Check if user exists by Id
		placeService.updatePlace(place);
		return new ResponseEntity<Place>(place, HttpStatus.OK);
	}
	
	@DeleteMapping("/place/{id}")
	public ResponseEntity<Void> deletePlace(@PathVariable("id") int id) {
		placeService.deletePlace(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
