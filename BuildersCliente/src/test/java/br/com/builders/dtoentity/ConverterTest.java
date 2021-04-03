package br.com.builders.dtoentity;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.builders.dto.ClienteDTO;
import br.com.builders.model.Cliente;

class ConverterTest {

	private ObjectMapper mapper = new ObjectMapper();
	
	@Test
	void toEntity() {
		ClienteDTO dto = new ClienteDTO();
		dto.setId(1);
		dto.setIdade(33);
		dto.setNome("Jesus");
	
		Cliente entity = mapper.convertValue(dto, Cliente.class);
		
		assertEquals(entity.getId(), dto.getId());
		
		assertEquals(entity.getNome(), dto.getNome());
		
		assertEquals(entity.getIdade(), dto.getIdade());
		
	}


	@Test
	void toDto() {
		Cliente entity = new Cliente();
		entity.setId(1);
		entity.setIdade(33);
		entity.setNome("Jesus");
	
		ClienteDTO dto = mapper.convertValue(entity, ClienteDTO.class);
		
		assertEquals(entity.getId(), dto.getId());
		
		assertEquals(entity.getNome(), dto.getNome());
		
		assertEquals(entity.getIdade(), dto.getIdade());
	}

}
