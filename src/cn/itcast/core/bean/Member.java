package cn.itcast.core.bean;

import java.io.Serializable;

public class Member  implements Serializable{
	
	private Integer memId;
	private Integer familyId;
	
	
	public Member() {
		super();
	}
	public Member(Integer memId, Integer familyId) {
		super();
		this.memId = memId;
		this.familyId = familyId;
	}
	public Integer getMemId() {
		return memId;
	}
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	public Integer getFamilyId() {
		return familyId;
	}
	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}
}
