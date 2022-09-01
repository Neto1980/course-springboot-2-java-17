package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

//@Component -> Registra a classe como componente do Spring.
@Service
public class OrderService {
	
	@Autowired // Serve para que o spring faça a injeção de dependencia mais tranparente para o programador.
	private OrderRepository repository;
	
	public List<Order> findAll(){ // Esse método retornará todos os usuários do banco de dados.
		return repository.findAll();
	}	
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
		
}
