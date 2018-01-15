package cn.itcast.core.bean.entity;

import java.io.Serializable;

public class Family  implements Serializable{
	
	private int familyId;
	private String familyName;
	private String familyLocation;
	private int familyGrade;
	private int delFlag;
	public Family() {
		super();
	}
	public Family(int familyId, String familyName, String familyLocation, int familyGrade, int delFlag) {
		super();
		this.familyId = familyId;
		this.familyName = familyName;
		this.familyLocation = familyLocation;
		this.familyGrade = familyGrade;
		this.delFlag = delFlag;
	}
	public int getFamilyId() {
		return familyId;
	}
	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFamilyLocation() {
		return familyLocation;
	}
	public void setFamilyLocation(String familyLocation) {
		this.familyLocation = familyLocation;
	}
	public int getFamilyGrade() {
		return familyGrade;
	}
	public void setFamilyGrade(int familyGrade) {
		this.familyGrade = familyGrade;
	}
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	
	
	
}
