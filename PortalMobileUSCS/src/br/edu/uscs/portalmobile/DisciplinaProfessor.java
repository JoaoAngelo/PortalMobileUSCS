package br.edu.uscs.portalmobile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "disciplina_professor")
public class DisciplinaProfessor {

	@DatabaseField(id = true)
	private int id_disciplina_professor;

	@DatabaseField(columnName = "id_disciplina", canBeNull = false, foreign = true)
	private Disciplina disciplina;

	@DatabaseField(columnName = "id_professor", canBeNull = false, foreign = true)
	private Professor professor;

	public DisciplinaProfessor() {
		// ORMLite needs a no-arg constructor
	}

	public DisciplinaProfessor(int id_disciplina_professor, Disciplina disciplina, Professor professor) {
		this.id_disciplina_professor = id_disciplina_professor;
		this.disciplina = disciplina;
		this.professor = professor;
	}

	public int getIdDisciplinaProfessor() {
		return id_disciplina_professor;
	}

	public void setIdDisciplinaProfessor(int id_disciplina_professor) {
		this.id_disciplina_professor = id_disciplina_professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}