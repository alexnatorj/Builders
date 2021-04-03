package br.com.builders.filter;

/**
 * Classe de filtro para pesquisa de Cliente.
 * @author alexandre monteiro
 * @since 02/04/2021
 */
public class ClienteFiltro {

	private Integer id;
	
	private String nome;
	
	private Integer idade;
	
	public ClienteFiltro() {
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
