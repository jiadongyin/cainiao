package cn.itcast.core.bean.dto;

import java.util.Date;

import cn.itcast.common.utils.excel.annotation.ExcelField;

public class MemberDto {

	private int memId ;           //id
    private String memName;       //名称
    private String memSex;       //性别
    private String memMarry;     //婚否
    private String memChildren;   //子女
    private String memWorh;       //丈夫或妻子
    private String memPhone;      //联系电话
    private String memAddress;    //现居地
    private String memPic;        //头像
    private int delFlag;          //删除标记
    private int familyId;         //家庭编号
    private String familyName;    //家庭名称
    private String familyLocation;//籍贯
    private Date createTime;      //创建时间
    private Date updateTime;      //修改时间
    private int isFinal;          //是否可修改
   
    //省市编号及名称
    private String provinceName; // 名称
    private String cityName;
    private String areaName;
    private String townName;
    private String province; //编号
    private String city;
    private String area;
    private String town;
    
    
    //分页
    private int start;
    private int rows;
	public MemberDto() {
		super();
	}
	
	public MemberDto(int memId, String memName, String memSex, String memMarry, String memChildren, String memWorh,
			String memPhone, String memAddress, String memPic, int delFlag, int familyId,String familyName,String familyLocation, Date createTime,
			Date updateTime, int isFinal, String provinceName, String cityName, String areaName, String townName,
			String province, String city, String area, String town, int start, int rows) {
		super();
		this.memId = memId;
		this.memName = memName;
		this.memSex = memSex;
		this.memMarry = memMarry;
		this.memChildren = memChildren;
		this.memWorh = memWorh;
		this.memPhone = memPhone;
		this.memAddress = memAddress;
		this.memPic = memPic;
		this.delFlag = delFlag;
		this.familyId = familyId;
		this.familyName = familyName;
		this.familyLocation = familyLocation;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isFinal = isFinal;
		this.provinceName = provinceName;
		this.cityName = cityName;
		this.areaName = areaName;
		this.townName = townName;
		this.province = province;
		this.city = city;
		this.area = area;
		this.town = town;
		this.start = start;
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
	@ExcelField(title="婚否", align=2, sort=4)
	public String getMemMarry() {
		return memMarry;
	}
	public void setMemMarry(String memMarry) {
		this.memMarry = memMarry;
	}
	@ExcelField(title="配偶", align=2, sort=5)
	public String getMemWorh() {
		return memWorh;
	}
	public void setMemWorh(String memWorh) {
		this.memWorh = memWorh;
	}
	@ExcelField(title="子女", align=2, sort=6)
	public String getMemChildren() {
		return memChildren;
	}
	public void setMemChildren(String memChildren) {
		this.memChildren = memChildren;
	}
	
	@ExcelField(title="联系电话", align=2, sort=7)
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	@ExcelField(title="现居地", align=2, sort=8)
	public String getMemAddress() {
		return memAddress;
	}
	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}
	public String getMemPic() {
		return memPic;
	}
	public void setMemPic(String memPic) {
		this.memPic = memPic;
	}
	public int getdelFlag() {
		return delFlag;
	}
	public void setdelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	public int getFamilyId() {
		return familyId;
	}
	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}
	@ExcelField(title="成员家庭", align=2, sort=9)
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getIsFinal() {
		return isFinal;
	}
	public void setIsFinal(int isFinal) {
		this.isFinal = isFinal;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
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
    
    
}
