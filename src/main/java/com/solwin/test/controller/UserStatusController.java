package com.solwin.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solwin.test.entity.UserStatus;
import com.solwin.test.service.IUserStatusService;

@RestController
@RequestMapping("/")
public class UserStatusController {
	@Autowired
	private IUserStatusService userStatusService;
	
	@GetMapping("/userStatus/{id}")
	public ResponseEntity<UserStatus> getUserStatusById(@PathVariable("id") Integer id) {
		return new ResponseEntity<UserStatus>(userStatusService.getUserStatusById(id), HttpStatus.OK);
	}
	
	@GetMapping("/userStatus")
	public ResponseEntity<List<UserStatus>> getAllUserStatus() {
		return new ResponseEntity<List<UserStatus>>(userStatusService.getAllUserStatus(), HttpStatus.OK);
	}
}
