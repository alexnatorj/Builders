package br.com.builders.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.builders.model.Cliente;



/**
 * Classes responsavel por realizar operações de banco de dados da classe Cliente.
 * @author alexandre monteiro
 * @since 02/04/2021
 */
public interface ClienteRepository extends CrudRepository<Cliente, Integer>, JpaSpecificationExecutor<Cliente> {

}
