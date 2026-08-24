package com.nelioalves.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.services.UserService;

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
	
	
	@Autowired
	private UserService service;
	
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
	public ResponseEntity<List<UserDTO>> findAll() {
		
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		/*
			Aqui nós criamos um objeto ResponseEntity utilizando o método "ok()",
			esse método cria um objeto com um código de retorno que indica que
			o programa funcionou. Então nós adicionamos no corpo da resposta a
			lista de objetos que nós criamos com todos os usuários.
		*/
		return ResponseEntity.ok().body(listDTO);	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	//PostMapping - Também funciona
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		this.service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
