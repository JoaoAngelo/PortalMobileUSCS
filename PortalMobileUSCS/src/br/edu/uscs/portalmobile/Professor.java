package br.edu.uscs.portalmobile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "professor")
public class Professor {

	@DatabaseField(id = true)
	private int id_professor;

	@DatabaseField(columnName = "id_pessoa", canBeNull = false, foreign = true)
	private Pessoa pessoa;

	public Professor() {
		// ORMLite requer um construtor sem argumentos
	}

	public Professor(int id_professor, Pessoa pessoa) {
		this.id_professor = id_professor;
		this.pessoa = pessoa;
	}

	public int getIdProfessor() {
		return id_professor;
	}

	public void setIdProfessor(int id_professor) {
		this.id_professor = id_professor;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
