package cn.itcast.core.dao;

import java.util.List;

import cn.itcast.core.bean.Family;
import cn.itcast.core.bean.FileDemo;
import cn.itcast.core.bean.QueryVo;

public interface MemberDao {


	List<QueryVo> findList(QueryVo queryVo);

	List<QueryVo> selectMemberList(QueryVo queryVo);

	Integer selectMemberListCount(QueryVo queryVo);

	QueryVo getmemberById(int id);

	void update(QueryVo queryVo);

	int add(QueryVo queryVo);

	void delete(int id);

	void fileUpload(FileDemo fileDemo);
	
	List<FileDemo> findFileList();


	List<Family> selectFamily();

}
