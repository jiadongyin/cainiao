package cn.itcast.core.service;

import java.util.List;

import cn.itcast.common.utils.Page;
import cn.itcast.core.bean.Family;
import cn.itcast.core.bean.FileDemo;
import cn.itcast.core.bean.Member;
import cn.itcast.core.bean.QueryVo;

public interface MemberService {

	Page<QueryVo> findMemberList(Integer page, Integer rows, QueryVo queryVo);

	List<Family> selectFamily();
	
	QueryVo getmemberById(int id);

	void updatemember(QueryVo queryVo);

	void addmember(QueryVo queryVo);

	void deletemember(Integer id);

	void fileUpload(FileDemo fileDemo);
	
	List<FileDemo> findFileList();

	List<QueryVo> findList(QueryVo queryVo);



}
