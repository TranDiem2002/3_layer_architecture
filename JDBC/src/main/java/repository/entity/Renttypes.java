package repository.entity;

import repository.annotation.Column;
import repository.annotation.Entity;
import repository.annotation.Table;

@Entity
@Table(name = "renttype")
public class Renttypes {

	@Column(name="id")
	private long id;
	
	@Column(name="code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
