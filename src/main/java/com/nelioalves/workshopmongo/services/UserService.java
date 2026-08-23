package com.nelioalves.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.tepository.UserRepository;

@Service
public class UserService {
	/**
		As classes de serviço escondem as regras de negócio da aplicação,
		aqui é onde ocorrem cálculos, sorteios, manipulação de dados, qualquer
		operação intermediária entre os dados brutos e a aplicação.
	*/
	
	// A anotação "Autowired" instancia os objetos de forma automática, permitindo
	// criar uma injeção de dependência sem a necessidade de um construtor ou método Set.
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		
		return this.repo.findAll();	// Método que recupera todos os objetos e retorna
		
	}
	
}
