package cn.itcast.core.bean;

import java.io.Serializable;

public class Family  implements Serializable{
	
	private String family_id;
	private String family_name;
	private String family_location;
	private String family_grade;
	public Family() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Family(String family_id, String family_name, String family_location, String family_grade) {
		super();
		this.family_id = family_id;
		this.family_name = family_name;
		this.family_location = family_location;
		this.family_grade = family_grade;
	}
	public String getFamily_id() {
		return family_id;
	}
	public void setFamily_id(String family_id) {
		this.family_id = family_id;
	}
	public String getFamily_name() {
		return family_name;
	}
	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}
	public String getFamily_location() {
		return family_location;
	}
	public void setFamily_location(String family_location) {
		this.family_location = family_location;
	}
	public String getFamily_grade() {
		return family_grade;
	}
	public void setFamily_grade(String family_grade) {
		this.family_grade = family_grade;
	}
	
	
}
