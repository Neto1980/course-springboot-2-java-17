package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//@Component -> Registra a classe como componente do Spring.
@Service
public class UserService {
	
	@Autowired // Serve para que o spring faça a injeção de dependencia mais tranparente para o programador.
	private UserRepository repository;
	
	public List<User> findAll(){ // Esse método retornará todos os usuários do banco de dados.
		return repository.findAll();
	}	
	
	public User findById(Long id) { // Método que retorna o usuário pelo "ID".
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
		
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
