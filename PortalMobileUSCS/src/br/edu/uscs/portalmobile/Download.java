package br.edu.uscs.portalmobile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "download")
public class Download {

	@DatabaseField(id = true)
	private int id_download;

	@DatabaseField(columnName = "id_disciplina_professor", canBeNull = false, foreign = true)
	private DisciplinaProfessor disciplina_professor;

	@DatabaseField
	private String descricao_download;

	@DatabaseField
	private String url;

	@DatabaseField
	private String data_insercao;

	public Download() {

	}

	public Download(int id_download, DisciplinaProfessor disciplina_professor, String descricao_download, String url, String data_insercao) {
		this.id_download = id_download;
		this.disciplina_professor = disciplina_professor;
		this.descricao_download = descricao_download;
		this.url = url;
		this.data_insercao = data_insercao;
	}

	public int getIdDownload() {
		return id_download;
	}

	public void setIdDownload(int id_download) {
		this.id_download = id_download;
	}

	public DisciplinaProfessor getDisciplinaProfessor() {
		return disciplina_professor;
	}

	public void setDisciplinaProfessor(DisciplinaProfessor disciplina_professor) {
		this.disciplina_professor = disciplina_professor;
	}

	public String getDescricaoDownload() {
		return descricao_download;
	}

	public void setDescricaoDownload(String descricao_download) {
		this.descricao_download = descricao_download;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDataInsercao() {
		return data_insercao;
	}

	public void setDataInsercao(String data_insercao) {
		this.data_insercao = data_insercao;
	}

}