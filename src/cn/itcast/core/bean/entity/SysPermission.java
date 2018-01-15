package cn.itcast.core.bean.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xiaoyin
 * @Date: 2017-12-28 14:21
 * @Description:
 */
public class SysPermission implements Serializable {

    // id :
    private int id;

    // name :名称
    private String name;

    // description :描述
    private String description;

    // create_time :创建时间
    private java.util.Date createTime;

    // update_time :更新时间
    private java.util.Date updateTime;

    // status :数据状态,1:正常,0:删除
    private Integer delFlag;

	public SysPermission() {
		super();
	}

	public SysPermission(int id, String name, String description, Date createTime, Date updateTime, Integer delFlag) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@Override
	public String toString() {
		return "SysPermission [id=" + id + ", name=" + name + ", description=" + description + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", delFlag=" + delFlag + "]";
	}

   
}
