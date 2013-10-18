package br.edu.uscs.portalmobile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "disciplina")
public class Disciplina {

	@DatabaseField(id = true)
	private int id_disicplina;

	@DatabaseField
	private String nome_disciplina;

	@DatabaseField
	private String sta_presencial;

	public Disciplina() {
		// ORMLite needs a no-arg constructor
	}

	public Disciplina(int id_disicplina, String nome_disciplina, String sta_presencial) {
		this.id_disicplina = id_disicplina;
		this.nome_disciplina = nome_disciplina;
		this.sta_presencial = sta_presencial;
	}

	public int getIdDisciplina() {
		return id_disicplina;
	}

	public void setIdDisciplina(int id_disicplina) {
		this.id_disicplina = id_disicplina;
	}

	public String getNomeDisciplina() {
		return nome_disciplina;
	}

	public void setNomeDisciplina(String nome_disciplina) {
		this.nome_disciplina = nome_disciplina;
	}

	public String getStaPresencial() {
		return sta_presencial;
	}

	public void setStaPresencial(String sta_presencial) {
		this.sta_presencial = sta_presencial;
	}
}