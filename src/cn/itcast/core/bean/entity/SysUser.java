package cn.itcast.core.bean.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xiaoyin
 * @Date: 2017-12-27 16:52
 * @Description:
 */
public class SysUser implements Serializable{

    // id :
    private int id;

    // login_name :登陆名
    private String loginName;

    // zh_name :中文名
    private String zhName;

    // en_name :英文名
    private String enName;

    // sex :性别
    private int sex;

    // email :邮箱
    private String email;

    // phone :电话
    private String phone;

    // address :地址
    private String address;

    // password :密码
    private String password;

    // create_time :创建时间
    private Date createTime;

    // update_time :更新时间
    private Date updateTime;

    // status :数据状态,1:正常,0:删除,
    private int delFlag;

	public SysUser() {
		super();
	}

	public SysUser(int id, String loginName, String zhName, String enName, int sex, String email, String phone,
			String address, String password, Date createTime, Date updateTime, int delFlag) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.zhName = zhName;
		this.enName = enName;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.password = password;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.delFlag = delFlag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getZhName() {
		return zhName;
	}

	public void setZhName(String zhName) {
		this.zhName = zhName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", loginName=" + loginName + ", zhName=" + zhName + ", enName=" + enName + ", sex="
				+ sex + ", email=" + email + ", phone=" + phone + ", address=" + address + ", password=" + password
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", delFlag=" + delFlag + "]";
	}

	
    
}
