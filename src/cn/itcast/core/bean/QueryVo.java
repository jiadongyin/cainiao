package cn.itcast.core.bean;

import java.io.Serializable;

import cn.itcast.common.utils.excel.annotation.ExcelField;

/*
 * 多表联合查询临时表
 */
public class QueryVo implements Serializable{

	private int memId;
	private String memName;
	private String memSex;
	private String familyId;
	private String familyName;
	private String birthday;
	private String familyLocation;
	private String familyGrade;
	private String province;
	private String city;
	private String area;
	private String town;
	private String memAddress;
	private String memChildren;
	private String memMarry;
	private String memPhone;
	private String worh;
	private String pic;
	
	//分页
	private Integer start;
	private Integer rows;
	
	public QueryVo() {
		super();
	}
	public QueryVo(int memId, String memName, String memSex, String familyId,String birthday, String familyName, 
			String familyLocation,String familyGrade, String province, String city, String area, String town, 
			String memAddress,String memChildren, String memMarry, String memPhone, String worh, String pic, 
			Integer start,Integer rows) {
		super();
		this.memId = memId;
		this.memName = memName;
		this.memSex = memSex;
		this.familyId = familyId;
		this.familyName = familyName;
		this.birthday = birthday;
		this.familyLocation = familyLocation;
		this.familyGrade = familyGrade;
		this.province = province;
		this.city = city;
		this.area = area;
		this.town = town;
		this.memAddress = memAddress;
		this.memChildren = memChildren;
		this.memMarry = memMarry;
		this.memPhone = memPhone;
		this.worh = worh;
		this.pic = pic;
		this.start = start;
		this.rows = rows;
	}
	
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
	
	
	
	@ExcelField(title="ID", align=2, sort=1)
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	@ExcelField(title="名称", align=2, sort=2)
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	@ExcelField(title="性别", align=2, sort=3)
	public String getMemSex() {
		return memSex;
	}
	public void setMemSex(String memSex) {
		this.memSex = memSex;
	}
	//@ExcelField(title="生日", align=2, sort=3)
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@ExcelField(title="婚否", align=2, sort=4)
	public String getMemMarry() {
		return memMarry;
	}
	public void setMemMarry(String memMarry) {
		this.memMarry = memMarry;
	}
	@ExcelField(title="配偶", align=2, sort=5)
	public String getWorh() {
		return worh;
	}
	public void setWorh(String worh) {
		this.worh = worh;
	}
	@ExcelField(title="子女", align=2, sort=6)
	public String getMemChildren() {
		return memChildren;
	}
	public void setMemChildren(String memChildren) {
		this.memChildren = memChildren;
	}
	public String getFamilyId() {
		return familyId;
	}
	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}
	@ExcelField(title="成员家庭", align=2, sort=7)
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	@ExcelField(title="籍贯", align=2, sort=8)
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
	@ExcelField(title="现居地", align=2, sort=9)
	public String getMemAddress() {
		return memAddress;
	}
	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	
	@ExcelField(title="电话", align=2, sort=10)
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
	
}
