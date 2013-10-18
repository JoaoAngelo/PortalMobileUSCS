package br.edu.uscs.portalmobile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "curso")
public class Curso {

	@DatabaseField(id = true)
	private int id_curso;

	@DatabaseField
	private String nome_curso;

	public Curso() {
		// ORMLite needs a no-arg constructor
	}

	public Curso(int id_curso, String nome_curso) {
		this.id_curso = id_curso;
		this.nome_curso = nome_curso;
	}

	public int getIdCurso() {
		return id_curso;
	}

	public void setIdCurso(int id_curso) {
		this.id_curso = id_curso;
	}

	public String getNomeCurso() {
		return nome_curso;
	}

	public void setNomeCurso(String nome_curso) {
		this.nome_curso = nome_curso;
	}
}