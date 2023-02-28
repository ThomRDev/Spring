package com.webservicesinopsys.webservicesinopsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SpringBootApplication
@RestController
public class WebserviceSinopsysApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceSinopsysApplication.class, args);
	}

	@GetMapping("/rnd")
	public ResponseEntity<Map<String,Object>> generateRndNumber() {
		Random rnd = new Random();
		var rsp = response("Numero Aleatorio", "",String.valueOf(rnd.nextDouble()));
		return ResponseEntity.status(HttpStatus.OK).header("Content-Type","application/json").body(rsp);
	}

	@GetMapping("/fibo/{value}")
	public ResponseEntity<Map<String,Object>> getFibo(@PathVariable("value") Integer value) {
		if(value<=0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Content-Type","application/json")
				.body(response("Fibonacci", String.valueOf(value), "El numero debe ser mayor que cero"));
		int fibo1 = 1;
		int fibo2 = 1;
		int aux = 1;
		String cadena = "1";
		for (int i = 2; i <= value; i++) {
			fibo2 += aux;
			aux = fibo1;
			fibo1 = fibo2;
			cadena += " " + aux;
		}
		return ResponseEntity.status(HttpStatus.OK).header("Content-Type","application/json")
				.body(response("Fibonacci", String.valueOf(value), cadena));
	}

	private static Map<String,Object>  response(String operation, String parameter, Object result) {
		Map<String,Object> obj = new HashMap();
		try {
			obj.put("operation", operation);
			obj.put("parameter", parameter);
			obj.put("result", result);
			return obj;
		} catch (Exception ex) {
			System.err.println("JSONException: " + ex.getMessage());
			return obj;
		}
	}

}
