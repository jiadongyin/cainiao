package cn.itcast.core.bean.entity;

import java.io.Serializable;
import java.util.Date;

public class Member  implements Serializable{
	
	private int memId ; 
    private String memName;
    private String memSex;
    private String memMarry;
    private String memChildren;
    private String memWorh;
    private String memPhone;
    private String memAddress;
    private String memPic;
    private int delFlag;
    private int familyId;
    private Date createTime;
    private Date updateTime;
    private int isFinal;
	public Member() {
		super();
	}
	public Member(int memId, String memName, String memSex, String memMarry, String memChildren, String memWorh,
			String memPhone, String memAddress, String memPic, int delFlag, int familyId, Date createTime,
			Date updateTime, int isFinal) {
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
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isFinal = isFinal;
	}
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
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
	public String getMemMarry() {
		return memMarry;
	}
	public void setMemMarry(String memMarry) {
		this.memMarry = memMarry;
	}
	public String getMemChildren() {
		return memChildren;
	}
	public void setMemChildren(String memChildren) {
		this.memChildren = memChildren;
	}
	public String getMemWorh() {
		return memWorh;
	}
	public void setMemWorh(String memWorh) {
		this.memWorh = memWorh;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
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
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	public int getFamilyId() {
		return familyId;
	}
	public void setFamilyId(int familyId) {
		this.familyId = familyId;
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
	
}
