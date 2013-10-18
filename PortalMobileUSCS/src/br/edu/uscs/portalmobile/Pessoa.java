package br.edu.uscs.portalmobile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "pessoa")
public class Pessoa {

	@DatabaseField(id = true)
	private int id_pessoa;

	@DatabaseField(canBeNull = false)
	private String nome_pessoa;

	@DatabaseField
	private String email;

	public Pessoa() {
		// ORMLite needs a no-arg constructor
	}

	public Pessoa(int id_pessoa, String nome_pessoa, String email) {
		this.id_pessoa = id_pessoa;
		this.nome_pessoa = nome_pessoa;
		this.email = email;
	}

	public int getIdPessoa() {
		return id_pessoa;
	}

	public void setIdPessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public String getNomePessoa() {
		return nome_pessoa;
	}

	public void setNomePessoa(String nome_pessoa) {
		this.nome_pessoa = nome_pessoa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}