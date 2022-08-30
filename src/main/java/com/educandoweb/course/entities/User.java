package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Serializable -> faz com que os objetos possam ser transformados em cadeia de dados, onde ele possa trafegar na rede ou ser gravado em arquivos.

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id // Indica que a primeira variável "id" será a chave primária.
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id; // Como o "id" é uma variável numérica, iremos implementar um incrementador "GeneratedValue".
	private String name;
	private String email;
	private String phone;
	private String password;
	
	public User() {
		
	}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
	// Só utilizamos o "id" para fazer a comparação entre os objetos.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	

}
