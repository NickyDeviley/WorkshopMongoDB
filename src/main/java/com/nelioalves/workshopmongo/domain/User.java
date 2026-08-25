package com.nelioalves.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
	Para esclarecer que essa classe representa um objeto que será
	tratado no banco mongoDB, nós utilizamos a anotação "Document",
	nós também podemos especificar a coleção, isso é, o nome que
	esses objetos terão no banco de dados.
*/
@Document(collection = "user")
public class User implements Serializable {
	/**
		Criar uma entidade checklist:
		
		Atributos;
		Associações;
		Construtores;
		Getters & Setters;
		HashCode & Equals;
		Serializable.
	*/
	
	private static final long serialVersionUID = 1L;

	// Atributes

	@Id
	private String id;
	private String name;
	private String email;
	
	// Associações
	@DBRef(lazy = true)
	private List<Post> posts = new ArrayList<>();
	
	// Constructors
	public User () {}
	public User (String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

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

	
	// Getters & Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	public List<Post> getPosts() {
		return posts;
	}
	

}
