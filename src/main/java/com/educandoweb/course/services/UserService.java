package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // Tenta retornar o "GET", caso não exista o usuário, ele lançará a exceção
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
		
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id) ;
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) { // Crio um método para atualizar o usuário, passando o id e os dados.
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
