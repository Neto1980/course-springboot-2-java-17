package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

//@Component -> Registra a classe como componente do Spring.
@Service
public class CategoryService {
	
	@Autowired // Serve para que o spring faça a injeção de dependencia mais tranparente para o programador.
	private CategoryRepository repository;
	
	public List<Category> findAll(){ // Esse método retornará todos os usuários do banco de dados.
		return repository.findAll();
	}	
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
		
}
