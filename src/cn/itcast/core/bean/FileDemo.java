package cn.itcast.core.bean;

import java.io.Serializable;

public class FileDemo implements Serializable{

	private String fileName;
	private String filePath;
	public FileDemo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileDemo(String fileName, String filePath) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;
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
	
	
}
