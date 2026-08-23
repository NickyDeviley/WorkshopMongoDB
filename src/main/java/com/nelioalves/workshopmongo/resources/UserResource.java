package com.nelioalves.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.workshopmongo.domain.User;

/*
	A anotação "RestController" mostra que essa é a camada
	de controller, onde a requisição do cliente será tratada
	para retornar os dados para a aplicação.
	
	O "RequestMapping" é uma anotação que diz qual será a
	URL para acessar essa classe.
*/
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	/*
		Para comunicar ao Spring que esse método serve para retornar arquivos
		para a aplicação, nós utilizamos a anotação "RequestMapping" e atribuímos
		o método GET, como exemplificado abaixo.
		
		Ou podemos utilizar a anotação mais enxuta "GetMapping"
		
		Não é bom retornar uma lista, como estávamos fazendo, devemos retornar
		um objeto do Spring chamado "ResponseEntity", esse tipo de objeto
		encapsula toda uma estrutura necessária para que possamos retornar
		respostas HTTP, com possíveis cabeçalhos, erros, etc.
	*/
	//GetMapping
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		
		/*
			Aqui nós criamos um objeto ResponseEntity utilizando o método "ok()",
			esse método cria um objeto com um código de retorno que indica que
			o programa funcionou. Então nós adicionamos no corpo da resposta a
			lista de objetos que nós criamos com todos os usuários.
		*/
		return ResponseEntity.ok().body(list);	
	}
	
}
