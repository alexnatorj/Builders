package br.com.builders.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.builders.dto.ClienteDTO;
import br.com.builders.filter.ClienteFiltro;
import br.com.builders.model.Cliente;

public interface ClienteService {

	ClienteDTO criar(ClienteDTO cliente) throws Exception ;
	
	ClienteDTO alterar(ClienteDTO cliente) throws Exception;

	Page<Cliente> listarClientes(ClienteFiltro filtro, Pageable page);

}
