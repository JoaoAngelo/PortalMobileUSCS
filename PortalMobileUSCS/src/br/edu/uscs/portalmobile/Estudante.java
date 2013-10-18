package br.edu.uscs.portalmobile;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "estudante")
public class Estudante {

	@DatabaseField(id = true)
	private int id_estudante;

	@DatabaseField(columnName = "id_pessoa", canBeNull = false, foreign = true)
	private Pessoa pessoa;

	@DatabaseField(canBeNull = false)
	// adicionar check S ou N aqui
	private String sta_logado;

	@DatabaseField(canBeNull = false)
	private Date data_acesso;

	public Estudante() {
		// ORMLite needs a no-arg constructor
	}

	public Estudante(int id_estudante, Pessoa pessoa, String sta_logado) {
		this.id_estudante = id_estudante;
		this.pessoa = pessoa;
		this.sta_logado = sta_logado;
		this.data_acesso = new Date();
	}

	public int getIdEstudante() {
		return id_estudante;
	}

	public void setIdEstudante(int id_estudante) {
		this.id_estudante = id_estudante;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getStaLogado() {
		return sta_logado;
	}

	public void setStaLogado(String sta_logado) {
		this.sta_logado = sta_logado;
	}

	public Date getDataAcesso() {
		return data_acesso;
	}

	public void setDataAcesso(Date data_acesso) {
		this.data_acesso = data_acesso;
	}
}