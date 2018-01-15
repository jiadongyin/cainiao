package cn.itcast.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.itcast.core.bean.dto.MemberDto;
import cn.itcast.core.bean.entity.Member;

public interface MemberMapper {

	List<Member> selectAll();
	Integer selectCounts();
	Member selectById(int id);
	void insert(Member member); 
	void update(Member member);
	List<Member> selectPage(@Param("start")Integer start, @Param("rows")Integer rows);
	void deleteById(Integer id);
	List<Member> selectPageWhere(MemberDto memberDto);


/*	QueryVo getmemberById(int id);
	
	List<MemberDto> findList(MemberDto memberDto);


	int add(QueryVo queryVo);

	void delete(int id);

	void fileUpload(FileDemo fileDemo);
	
	List<FileDemo> findFileList(String fileName);


	List<Family> selectFamily();

	Family findFamilyLocation(String picPrefix);

	*/

}
