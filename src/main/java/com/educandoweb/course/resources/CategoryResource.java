package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	// O resonseEntity -> É o método específico do Spring e o correto para efetuar respostas de solicitação Web. O tipo da resposta será a minha classe "Category".
	// findAll() -> É o método que retorna meus usuários.
	
		@Autowired
		private CategoryService service;
	
		@GetMapping // Essa anotation faz com que esse método "ResponseEntity" retorne as requisições "Get" do HTTP. 
		public ResponseEntity<List<Category>> findAll() { 
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Category> findById(@PathVariable Long id){
			Category obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		}
		
		// O responseEntity.ok -> Retorna que está tudo "OK". 
}


