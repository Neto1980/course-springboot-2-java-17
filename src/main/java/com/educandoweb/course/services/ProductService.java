package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

//@Component -> Registra a classe como componente do Spring.
@Service
public class ProductService {
	
	@Autowired // Serve para que o spring faça a injeção de dependencia mais tranparente para o programador.
	private ProductRepository repository;
	
	public List<Product> findAll(){ // Esse método retornará todos os usuários do banco de dados.
		return repository.findAll();
	}	
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
		
}
