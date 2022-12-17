package br.com.articuno.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.articuno.model.User;
import br.com.articuno.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user) {
		User created = userService.save(user);
		if( created != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(created);
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestBody Map<String, String> auth){
		if(auth.containsKey("email") && auth.containsKey("password")) {
			String email = auth.get("email");
			String pwd = auth.get("password");
			if(userService.validaSenha(email, pwd)== true) {
				return ResponseEntity.ok(true);
			} else {
				return ResponseEntity.badRequest().body(false);
			}
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
	}
}
