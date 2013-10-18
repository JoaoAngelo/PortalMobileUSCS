package br.edu.uscs.portalmobile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "curso_disciplina")
public class CursoDisciplina {

	@DatabaseField(id = true)
	private int id_curso_disciplina;

	@DatabaseField(columnName = "id_curso", canBeNull = false, foreign = true)
	private Curso curso;

	@DatabaseField(columnName = "id_disciplina", canBeNull = false, foreign = true)
	private Disciplina disciplina;

	public CursoDisciplina() {
		// ORMLite needs a no-arg constructor
	}

	public CursoDisciplina(int id_curso_disciplina, Curso curso, Disciplina disciplina) {
		this.id_curso_disciplina = id_curso_disciplina;
		this.curso = curso;
		this.disciplina = disciplina;
	}

	public int getIdCursoDisciplina() {
		return id_curso_disciplina;
	}

	public void setIdCursoDisciplina(int id_curso_disciplina) {
		this.id_curso_disciplina = id_curso_disciplina;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}