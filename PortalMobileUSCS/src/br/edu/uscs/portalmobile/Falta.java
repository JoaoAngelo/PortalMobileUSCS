package br.edu.uscs.portalmobile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "falta")
public class Falta {

	@DatabaseField(id = true)
	private int id_falta;

	@DatabaseField(columnName = "id_disciplina_professor", canBeNull = false, foreign = true)
	private DisciplinaProfessor disciplinaProfessor;

	@DatabaseField(columnName = "id_estudante", canBeNull = false, foreign = true)
	private Estudante estudante;

	@DatabaseField
	private int qtd_faltas;

	@DatabaseField
	private int limite_faltas;

	public Falta() {
		// ORMLite needs a no-arg constructor
	}

	public Falta(int id_falta, DisciplinaProfessor disciplinaProfessor, Estudante estudante, int qtd_faltas, int limite_faltas) {
		this.id_falta = id_falta;
		this.disciplinaProfessor = disciplinaProfessor;
		this.estudante = estudante;
		this.qtd_faltas = qtd_faltas;
		this.limite_faltas = limite_faltas;
	}

	public int getIdFalta() {
		return id_falta;
	}

	public void setIdFalta(int id_falta) {
		this.id_falta = id_falta;
	}

	public DisciplinaProfessor getDisciplinaProfessor() {
		return disciplinaProfessor;
	}

	public void setDisciplinaProfessor(DisciplinaProfessor disciplinaProfessor) {
		this.disciplinaProfessor = disciplinaProfessor;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public int getQtdFaltas() {
		return qtd_faltas;
	}

	public void setQtdFaltas(int qtd_faltas) {
		this.qtd_faltas = qtd_faltas;
	}

	public int getLimiteFaltas() {
		return limite_faltas;
	}

	public void setLimiteFaltas(int limite_faltas) {
		this.limite_faltas = limite_faltas;
	}

}