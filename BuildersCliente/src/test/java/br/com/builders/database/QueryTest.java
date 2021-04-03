package br.com.builders.database;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.builders.ClienteApplication;
import br.com.builders.model.Cliente;
import br.com.builders.repository.ClienteRepository;
import br.com.builders.repository.specifications.ClienteSpecification;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ClienteApplication.class)
@ContextConfiguration
@Transactional
class QueryTest {


	@Autowired
	private ClienteRepository clienteRepository;

	private Cliente clienteJesus;
	private Cliente clienteMaria;

	@BeforeEach
	public  void initialize() {
		clienteJesus = new Cliente();
		clienteJesus.setIdade(33);
		clienteJesus.setNome("Jesus");

		clienteMaria = new Cliente();
		clienteMaria.setIdade(45);
		clienteMaria.setNome("Maria");

	}

	@Test
	public void criarCliente() {
		clienteJesus = clienteRepository.save(clienteJesus);

		clienteMaria = clienteRepository.save(clienteMaria);

		assertTrue(clienteJesus.getId() != null);

		assertTrue(clienteMaria.getId() != null);
	}
	
	@Test
	public void alterarCliente() {
		clienteJesus = clienteRepository.save(clienteJesus);
		Integer idadeOld = new Integer(clienteJesus.getIdade());
		clienteJesus.setIdade(34);
		clienteJesus = clienteRepository.save(clienteJesus);
		
		assertNotEquals(idadeOld, clienteJesus.getIdade());

	}

	@Test
	public void buscarPorNome() {
		clienteJesus = clienteRepository.save(clienteJesus);
		clienteMaria = clienteRepository.save(clienteMaria);
		
		Specification<Cliente> param = Specification
				.where(ClienteSpecification.getClientesPorNome(clienteJesus.getNome()));
		List<Cliente> results = clienteRepository.findAll(param);
		assertTrue(results.contains(clienteJesus));
		assertFalse(results.contains(clienteMaria));
	}

	@Test
	public void buscarPorIdade() {
		clienteJesus = clienteRepository.save(clienteJesus);
		clienteMaria = clienteRepository.save(clienteMaria);
		
		Specification<Cliente> param = Specification
				.where(ClienteSpecification.getClientesPorIdade(clienteMaria.getIdade()));
		List<Cliente> results = clienteRepository.findAll(param);
		assertTrue(results.contains(clienteMaria));
		assertFalse(results.contains(clienteJesus));
	}

}
