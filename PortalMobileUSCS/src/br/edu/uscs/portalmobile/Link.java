package br.edu.uscs.portalmobile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "link")
public class Link {

	@DatabaseField(id = true)
	private int id_link;

	@DatabaseField
	private String descricao_link;

	@DatabaseField
	private String url;

	public Link() {
		// ORMLite needs a no-arg constructor
	}

	public Link(int id_link, String descricao_link, String url) {
		this.id_link = id_link;
		this.descricao_link = descricao_link;
		this.url = url;
	}

	public int getId_link() {
		return id_link;
	}

	public void setId_link(int id_link) {
		this.id_link = id_link;
	}

	public String getDescricao_link() {
		return descricao_link;
	}

	public void setDescricao_link(String descricao_link) {
		this.descricao_link = descricao_link;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}