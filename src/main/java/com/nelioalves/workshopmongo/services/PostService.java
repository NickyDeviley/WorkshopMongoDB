package com.nelioalves.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;
import com.nelioalves.workshopmongo.tepository.PostRepository;

public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById (String id) {
		/*
			O instrutor utilizou o método "findOne(String)" que não existe mais,
			então esse método está adaptado para o Spring atual.
		*/
		Optional<Post> user = this.repo.findById(id);
//		if (user == null) {
//			throw new ObjectNotFoundException("Objeto não encontrado");
//		}

		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle (String text) {
		
		return repo.findByTitleContaining(text);
		
	}
	
}
