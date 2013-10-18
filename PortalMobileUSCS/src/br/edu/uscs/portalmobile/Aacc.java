package br.edu.uscs.portalmobile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "aacc")
public class Aacc {

	@DatabaseField(id = true)
	
	private int id_aacc;

	@DatabaseField(columnName = "id_estudante", canBeNull = false, foreign = true)
	private Estudante estudante;

	@DatabaseField
	private int qtd_horas;

	public Aacc() {
		// ORMLite needs a no-arg constructor
	}

	public Aacc(int id_aacc, Estudante estudante, int qtd_horas) {
		this.id_aacc = id_aacc;
		this.estudante = estudante;
		this.qtd_horas = qtd_horas;
	}

	public int getIdAacc() {
		return id_aacc;
	}

	public void setIdAacc(int id_aacc) {
		this.id_aacc = id_aacc;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public int getQtdHoras() {
		return qtd_horas;
	}

	public void setQtdHoras(int qtd_horas) {
		this.qtd_horas = qtd_horas;
	}
}