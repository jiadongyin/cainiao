package cn.itcast.core.bean;

import java.io.Serializable;

/*
 * 多表联合查询临时表
 */
public class QueryVo implements Serializable{

	private String memId;
	private String memName;
	private String memSex;
	private String familyId;
	private String familyName;
	private String familyLocation;
	private String familyGrade;
	private String memAddress;
	private String memChildren;
	private String memMarry;
	private String memPhone;
	private String worh;
	private String pic;
	
	//分页
	private Integer start;
	private Integer rows;
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public QueryVo() {
		super();
	}
	public QueryVo(String memId, String memName, String memSex, String familyId, String familyName,
			String familyLocation, String familyGrade, String memAddress, String memChildren, String memMarry,
			String memPhone, String worh, String pic, Integer start, Integer rows) {
		super();
		this.memId = memId;
		this.memName = memName;
		this.memSex = memSex;
		this.familyId = familyId;
		this.familyName = familyName;
		this.familyLocation = familyLocation;
		this.familyGrade = familyGrade;
		this.memAddress = memAddress;
		this.memChildren = memChildren;
		this.memMarry = memMarry;
		this.memPhone = memPhone;
		this.worh = worh;
		this.pic = pic;
		this.start = start;
		this.rows = rows;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemSex() {
		return memSex;
	}
	public void setMemSex(String memSex) {
		this.memSex = memSex;
	}
	public String getFamilyId() {
		return familyId;
	}
	public void setFamilyId(String familyId) {
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
	public String getFamilyGrade() {
		return familyGrade;
	}
	public void setFamilyGrade(String familyGrade) {
		this.familyGrade = familyGrade;
	}
	public String getMemAddress() {
		return memAddress;
	}
	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}
	public String getMemChildren() {
		return memChildren;
	}
	public void setMemChildren(String memChildren) {
		this.memChildren = memChildren;
	}
	public String getMemMarry() {
		return memMarry;
	}
	public void setMemMarry(String memMarry) {
		this.memMarry = memMarry;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getWorh() {
		return worh;
	}
	public void setWorh(String worh) {
		this.worh = worh;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
}
