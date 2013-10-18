package br.edu.uscs.portalmobile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "turma")
public class Turma {

	@DatabaseField(id = true)
	private int id_turma;

	@DatabaseField(canBeNull = false, unique = true)
	private String codigo_turma;

	@DatabaseField
	private int numero_sala;

	public Turma() {
		// ORMLite needs a no-arg constructor
	}

	public Turma(int id_turma, String codigo_turma, int numero_sala) {
		this.id_turma = id_turma;
		this.codigo_turma = codigo_turma;
		this.numero_sala = numero_sala;
	}

	public int getIdTurma() {
		return id_turma;
	}

	public void setIdTurma(int id_turma) {
		this.id_turma = id_turma;
	}

	public String getCodigoTurma() {
		return codigo_turma;
	}

	public void setCodigoTurma(String codigo_turma) {
		this.codigo_turma = codigo_turma;
	}

	public int getNumeroSala() {
		return numero_sala;
	}

	public void setNumeroSala(int numero_sala) {
		this.numero_sala = numero_sala;
	}
}