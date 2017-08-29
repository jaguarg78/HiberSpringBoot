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

import com.solwin.test.entity.Subscription;
import com.solwin.test.service.ISubscriptionService;

@RestController
@RequestMapping("/")
public class SubscriptionController {
	@Autowired
	private ISubscriptionService subscriptionService;
	
	@GetMapping("/subscription/{id}")
	public ResponseEntity<Subscription> getSubscriptionById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Subscription>(subscriptionService.getSubscriptionById(id), HttpStatus.OK);
	}
	
	@GetMapping("/subscriptions")
	public ResponseEntity<List<Subscription>> getAllSubscriptions() {
		return new ResponseEntity<List<Subscription>>(subscriptionService.getAllSubscriptions(), HttpStatus.OK);
	}
	
	@PostMapping("/subscription")
	public ResponseEntity<Void> addSubscription(@RequestBody Subscription subscription, UriComponentsBuilder builder) {
        if (!subscriptionService.addSubscription(subscription)) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/subscription/{id}").buildAndExpand(subscription.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/subscription")
	public ResponseEntity<Subscription> updateSubscription(@RequestBody Subscription subscription) {
		// TODO Check if article exists by Id
		subscriptionService.updateSubscription(subscription);
		return new ResponseEntity<Subscription>(subscription, HttpStatus.OK);
	}
	
	@DeleteMapping("/subscription/{id}")
	public ResponseEntity<Void> deleteSubscription(@PathVariable("id") Integer id) {
		subscriptionService.deleteSubscription(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
