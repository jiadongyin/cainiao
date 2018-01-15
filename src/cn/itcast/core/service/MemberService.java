package cn.itcast.core.service;

import java.util.List;

import cn.itcast.common.utils.Page;
import cn.itcast.core.bean.dto.MemberDto;
import cn.itcast.core.bean.entity.Family;
import cn.itcast.core.bean.entity.FileDemo;
import cn.itcast.core.bean.entity.Member;
import cn.itcast.core.bean.entity.Pcat;

public interface MemberService {


	Page<MemberDto> findMemberList(Integer page, Integer rows);

	List<Family> selectFamily();

	Member selectById(int id);
	
	void addmember(MemberDto memberDto);
	
	void updatemember(MemberDto memberDto);

	Pcat selectPcatById(int memId);

	Family selectFamilyById(int familyId);
	
	void deletemember(Integer id);
	
	void fileUpload(FileDemo fileDemo);

	List<FileDemo> findFileList(String picPrefix);
	
	Family findFamilyLocation(String picPrefix);

	Page<MemberDto> selectPageWhere(Integer page, Integer rows, MemberDto memberDto);

	List<MemberDto> findList();

	List<FileDemo> findAll();

}
