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
import com.solwin.test.entity.Payment;
import com.solwin.test.service.IPaymentService;
import com.solwin.test.structures.DateRange;

@RestController
@RequestMapping("/")
public class PaymentController {
	@Autowired
	private IPaymentService paymentService;

	@GetMapping("/payment/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("id") BigInteger id) {
		return new ResponseEntity<Payment>(paymentService.getPaymentById(id), HttpStatus.OK);
	}
	
	@GetMapping("/payments")
	public ResponseEntity<List<Payment>> getAllPayments() {
		return new ResponseEntity<List<Payment>>(paymentService.getAllPayments(), HttpStatus.OK);
	}
	
	@GetMapping("/payments/user/{id}")
	public ResponseEntity<List<Payment>> getPaymentsByUser(@PathVariable("id") BigInteger userId) {
		
		return new ResponseEntity<List<Payment>>(paymentService.getPaymentsByUser(userId), HttpStatus.OK);
	}
	
	@GetMapping("/payments/subscription/{id}")
	public ResponseEntity<List<Payment>> getPaymentsBySubscription(@PathVariable("id") Integer subscriptionId) {
		return new ResponseEntity<List<Payment>>(paymentService.getPaymentsBySubscription(subscriptionId), HttpStatus.OK);
	}
	
	@GetMapping("/payments/{jsonRange}")
	public ResponseEntity<List<Payment>> getPaymentsByDateRange(@PathVariable("jsonRange") String sJSONRange) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return new ResponseEntity<List<Payment>>(
					paymentService
						.getPaymentsByDateRange(mapper.readValue(sJSONRange, DateRange.class)), 
						                        HttpStatus.OK);
	}
	
	@PostMapping("/payment")
	public ResponseEntity<Void> addUser(@RequestBody Payment payment, UriComponentsBuilder builder) {
        if (!paymentService.addPayment(payment)) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/payment/{id}").buildAndExpand(payment.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/payment")
	public ResponseEntity<Payment> updateUser(@RequestBody Payment payment) {
		// TODO Check if user exists by Id
		paymentService.updatePayment(payment);
		return new ResponseEntity<Payment>(payment, HttpStatus.OK);
	}
	
	@DeleteMapping("/payment/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") BigInteger id) {
		paymentService.deletePayment(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}