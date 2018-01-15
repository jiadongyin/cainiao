package cn.itcast.core.bean.entity;

import java.io.Serializable;
import java.util.Date;

public class FileDemo implements Serializable{

	private int id;          //id
	private String fileName; //文件名
	private String filePath; //文件路径
	private String picPrefix;//前缀
	private Date createTime; //创建时间
	private Date updateTime; //修改时间
	private int delFlag;     //删除标记 0 删除， 1 正常
	
	public FileDemo() {
		super();
	}

	public FileDemo(int id, String fileName, String filePath, String picPrefix, Date createTime, Date updateTime,
			int delFlag) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.filePath = filePath;
		this.picPrefix = picPrefix;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getPicPrefix() {
		return picPrefix;
	}

	public void setPicPrefix(String picPrefix) {
		this.picPrefix = picPrefix;
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
	
}
