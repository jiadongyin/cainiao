package cn.itcast.core.bean;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable{

	private int role_id;
	private String role_name;
	private Date  created_time;
	private Date  update_time;
	public Role() {
		super();
	}
	public Role(int role_id, String role_name, Date created_time, Date update_time) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.created_time = created_time;
		this.update_time = update_time;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	
}
