package cn.itcast.core.bean.dto;

import java.util.Date;
import java.util.List;

import cn.itcast.core.bean.entity.SysPermission;

public class SysRoleDto {
	// id :
    private int id;

    // description :
    private String description;

    // name :
    private String name;

    // create_time :创建时间
    private java.util.Date createTime;

    // update_time :更新时间
    private java.util.Date updateTime;

    // status :数据状态,1:正常,0:删除
    private Integer delFlag;
    
    private List<SysPermission> sysPermissions;

	public SysRoleDto() {
		super();
	}

	public SysRoleDto(int id, String description, String name, Date createTime, Date updateTime, Integer delFlag,
			List<SysPermission> sysPermissions) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.delFlag = delFlag;
		this.sysPermissions = sysPermissions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public List<SysPermission> getSysPermissions() {
		return sysPermissions;
	}

	public void setSysPermissions(List<SysPermission> sysPermissions) {
		this.sysPermissions = sysPermissions;
	}

	@Override
	public String toString() {
		return "SysRoleDto [id=" + id + ", description=" + description + ", name=" + name + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", delFlag=" + delFlag + ", sysPermissions=" + sysPermissions + "]";
	}
    
    
}
