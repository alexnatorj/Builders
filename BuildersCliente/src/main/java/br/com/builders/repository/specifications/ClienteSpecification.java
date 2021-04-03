package br.com.builders.repository.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.builders.model.Cliente;

/**
 * Classe responsável por criar o specification para cada campo da classe Cliente.
 * @author alexandre monteiro
 * @since 02/04/2021
 */
public class ClienteSpecification {

	public static Specification<Cliente> getClientesPorNome(String nome) {
		return new Specification<Cliente>() {
			@Override
			public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Predicate nomePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), nome.toLowerCase() + "%");
				return nomePredicate;
			}
		};
	}
	
	public static Specification<Cliente> getClientesPorIdade(Integer  idade) {
		return new Specification<Cliente>() {
			@Override
			public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Predicate idadePredicate = criteriaBuilder.equal(root.get("idade"), idade);
				return idadePredicate;
			}
		};
	}
	
	public static Specification<Cliente> getClientesPorId(Integer  id) {
		return new Specification<Cliente>() {
			@Override
			public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Predicate idadePredicate = criteriaBuilder.equal(root.get("id"), id);
				return idadePredicate;
			}
		};
	}

}
