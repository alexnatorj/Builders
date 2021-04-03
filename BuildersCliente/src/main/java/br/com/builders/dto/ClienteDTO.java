package br.com.builders.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * Classe DTO da entidade Cliente.
 * @author alexandre monteiro
 * @since 02/04/2021
 */
@JsonInclude(Include.NON_NULL)
public class ClienteDTO implements Serializable {

	private Integer id;
	
	private String nome;
	
	private Integer idade;
	
	public ClienteDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	
}
