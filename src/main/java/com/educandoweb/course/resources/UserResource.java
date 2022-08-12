package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	// O resonseEntity -> É o método específico do Spring e o correto para efetuar respostas de solicitação Web. O tipo da resposta será a minha classe "User".
	// findAll() -> É o método que retorna meus usuários.
	@GetMapping
	public ResponseEntity<User> findAll() { 
		User u = new User(1L, "Maria", "maria@gmail.com", "99877-2143", "12345678");
		return ResponseEntity.ok().body(u);
		
		// O responseEntity.ok -> Retorna que está tudo "OK". 
	}

}
