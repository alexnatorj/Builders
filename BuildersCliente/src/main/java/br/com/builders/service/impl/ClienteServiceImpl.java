package br.com.builders.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.builders.dto.ClienteDTO;
import br.com.builders.filter.ClienteFiltro;
import br.com.builders.model.Cliente;
import br.com.builders.repository.ClienteRepository;
import br.com.builders.repository.specifications.ClienteSpecification;
import br.com.builders.service.ClienteService;


/**
 * Classes de serviço para execução das ações da classe Cliente.
 * @author alexandre monteiro
 * @since 02/04/2021
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	private final ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Override
	public ClienteDTO criar(ClienteDTO dto) throws Exception {
		if (dto.getId() != null) {
			throw new Exception("Este cliente não pode ser criado, pois já tem um id.");
		}
		Cliente entity = mapper.convertValue(dto, Cliente.class);
		entity = clienteRepository.save(entity);
		return mapper.convertValue(entity, ClienteDTO.class);
	}
	

	@Override
	public ClienteDTO alterar(ClienteDTO dto) throws Exception {
		if (dto.getId() == null || dto.getId() == 0) {
			throw new Exception("Informe o id do cliente para alteração.");
		}
		Cliente entity = mapper.convertValue(dto, Cliente.class);
		entity = clienteRepository.save(entity);
		return mapper.convertValue(entity, ClienteDTO.class);
	}


	@Override
	public Page<Cliente> listarClientes(ClienteFiltro filtro, Pageable page) {
		if (filtro == null) {
			return clienteRepository.findAll(null, page);
		} else {
			
			Specification<Cliente> specs = Specification.where(null);
			
			if (StringUtils.isNotBlank(filtro.getNome())) {
				specs = specs.and(ClienteSpecification.getClientesPorNome(filtro.getNome()));
			}
			
			if (filtro.getIdade() != null) {
				specs = specs.and(ClienteSpecification.getClientesPorIdade(filtro.getIdade()));
			}
			
			return clienteRepository.findAll(specs, page);
		}
	}

}
