package com.synopsis.dbdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/example")
public class ExampleController {
	@GetMapping
	public ResponseEntity<Map<String,String>> goHome() {
		Map<String,String> response = new HashMap<>();
		response.put("msg","todo ok");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
