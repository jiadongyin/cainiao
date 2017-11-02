package cn.itcast.core.bean;

import java.io.Serializable;

public class Info  implements Serializable{

	private String id;
	private String name;
	private String sex;
	private String marry;
	private String children;
	private String worh;
	private String phone;
	private String address;
	public Info() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Info(String id, String name, String sex, String marry, String children, String worh, String phone,
			String address) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.marry = marry;
		this.children = children;
		this.worh = worh;
		this.phone = phone;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMarry() {
		return marry;
	}
	public void setMarry(String marry) {
		this.marry = marry;
	}
	public String getChildren() {
		return children;
	}
	public void setChildren(String children) {
		this.children = children;
	}
	public String getWorh() {
		return worh;
	}
	public void setWorh(String worh) {
		this.worh = worh;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
