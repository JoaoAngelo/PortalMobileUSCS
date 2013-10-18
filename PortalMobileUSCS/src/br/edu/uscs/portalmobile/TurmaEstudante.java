package br.edu.uscs.portalmobile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "turma_estudante")
public class TurmaEstudante {

	@DatabaseField(id = true)
	private int id_turma_estudante;

	@DatabaseField(columnName = "id_turma", canBeNull = false, foreign = true)
	private Turma turma;

	@DatabaseField(columnName = "id_estudante", canBeNull = false, foreign = true)
	private Estudante estudante;

	public TurmaEstudante() {
		// ORMLite needs a no-arg constructor
	}

	public TurmaEstudante(int id_turma_estudante, Turma turma, Estudante estudante) {
		this.id_turma_estudante = id_turma_estudante;
		this.turma = turma;
		this.estudante = estudante;
	}

	public int getIdTurmaEstudante() {
		return id_turma_estudante;
	}

	public void setIdTurmaEstudante(int id_turma_estudante) {
		this.id_turma_estudante = id_turma_estudante;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
}