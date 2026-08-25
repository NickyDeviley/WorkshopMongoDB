package com.nelioalves.workshopmongo.tepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.nelioalves.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	/**
		Essa é a interface que se comunica com o banco de dados
		para que todo o sistema de camadas REST funcione.
		
		A anotação "Repository" diz ao spring que essa classe serve
		para acessar o banco de dados, porém, para que as operações
		com o banco de dados Mongo funcione, é necessário extender a
		classe "MongoRespository", e especificar qual é o objeto
		que vamos manipular, nesse caso "User" e o tipo de dado
		que usamos para identificar ele, no caso "String".
		
		A classe "MongoRespository" já possuí todos os métodos
		para que nós possamos acessar todos os dados do banco,
		sem a necessidade de que tenhamos que escrever os comandos
		exatos.
	*/
	
	List<Post> findByTitleContainingIgnoreCase (String text);
	
	@Query("{ 'Title': {$regex: ?0, $options: 'i'}}")
	List<Post> findByTitle (String text);
}
