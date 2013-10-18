package br.edu.uscs.portalmobile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "grade_horaria")
public class GradeHoraria {

	@DatabaseField(id = true)
	private int id_grade_horaria;

	@DatabaseField(columnName = "id_disciplina_professor", canBeNull = false, foreign = true)
	private DisciplinaProfessor disciplinaProfessor;

	@DatabaseField
	private int dia_semana;

	@DatabaseField
	private String hora_inicio;

	@DatabaseField
	private String hora_fim;

	public GradeHoraria() {
		// ORMLite needs a no-arg constructor
	}

	public GradeHoraria(int id_grade_horaria, DisciplinaProfessor disciplinaProfessor, int dia_semana, String hora_inicio, String hora_fim) {
		this.id_grade_horaria = id_grade_horaria;
		this.disciplinaProfessor = disciplinaProfessor;
		this.dia_semana = dia_semana;
		this.hora_inicio = hora_inicio;
		this.hora_fim = hora_fim;
	}

	public int getIdGradeHoraria() {
		return id_grade_horaria;
	}

	public void setIdGradeHoraria(int id_grade_horaria) {
		this.id_grade_horaria = id_grade_horaria;
	}

	public DisciplinaProfessor getDisciplinaProfessor() {
		return disciplinaProfessor;
	}

	public void setDisciplinaProfessor(DisciplinaProfessor disciplinaProfessor) {
		this.disciplinaProfessor = disciplinaProfessor;
	}

	public int getDiaSemana() {
		return dia_semana;
	}

	public void setDiaSemana(int dia_semana) {
		this.dia_semana = dia_semana;
	}

	public String getHoraInicio() {
		return hora_inicio;
	}

	public void setHoraInicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public String getHoraFim() {
		return hora_fim;
	}

	public void setHoraFim(String hora_fim) {
		this.hora_fim = hora_fim;
	}

}