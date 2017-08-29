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

import com.solwin.test.entity.Site;
import com.solwin.test.service.ISiteService;

@RestController
@RequestMapping("/")
public class SiteController {
	@Autowired
	private ISiteService siteService;
	
	@GetMapping("/site/{id}")
	public ResponseEntity<Site> getSiteById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Site>(siteService.getSiteById(id), HttpStatus.OK);
	}
	
	@GetMapping("/sites")
	public ResponseEntity<List<Site>> getAllSites() {
		return new ResponseEntity<List<Site>>(siteService.getAllSites(), HttpStatus.OK);
	}
	
	@PostMapping("/site")
	public ResponseEntity<Void> addSite(@RequestBody Site site, UriComponentsBuilder builder) {
        if (!siteService.addSite(site)) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/site/{id}").buildAndExpand(site.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/site")
	public ResponseEntity<Site> updateSite(@RequestBody Site site) {
		// TODO Check if site exists by Id
		siteService.updateSite(site);
		return new ResponseEntity<Site>(site, HttpStatus.OK);
	}
	
	@DeleteMapping("/site/{id}")
	public ResponseEntity<Void> deleteSite(@PathVariable("id") Integer id) {
		siteService.deleteSite(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
