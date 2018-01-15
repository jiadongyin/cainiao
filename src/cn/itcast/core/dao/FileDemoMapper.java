package cn.itcast.core.dao;

import java.util.List;

import cn.itcast.core.bean.entity.FileDemo;

public interface FileDemoMapper {

	void insert(FileDemo fileDemo);

	List<FileDemo> selectByPrefix(String picPrefix);

	List<FileDemo> selectAll();

}
