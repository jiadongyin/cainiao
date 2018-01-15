package cn.itcast.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.redis.JedisUtils;
import cn.itcast.common.utils.JsonUtils;
import cn.itcast.common.utils.Page;
import cn.itcast.common.utils.PropertyCopyUtil;
import cn.itcast.common.utils.StringUtils;
import cn.itcast.core.bean.dto.MemberDto;
import cn.itcast.core.bean.entity.Family;
import cn.itcast.core.bean.entity.FileDemo;
import cn.itcast.core.bean.entity.Member;
import cn.itcast.core.bean.entity.Pcat;
import cn.itcast.core.dao.FamilyMapper;
import cn.itcast.core.dao.FileDemoMapper;
import cn.itcast.core.dao.MemberMapper;
import cn.itcast.core.dao.PcatMapper;
import cn.itcast.core.service.MemberService;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {
	
	// 定义dao属性
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FamilyMapper familyMapper;
	@Autowired
	private PcatMapper pcatMapper;
	@Autowired
	private FileDemoMapper fileDemoMapper;
	


	@Override
	public Page<MemberDto> findMemberList(Integer page, Integer rows) {
		//limit查询起始位置
		int start = (page-1) * rows;		
		//limit查询
		List<Member> members = memberMapper.selectPage(start,rows);
		List<MemberDto> listDto = new ArrayList<MemberDto>();
		for (Member member : members) {
			Family family = familyMapper.selectById(member.getFamilyId());
			MemberDto memberDto = new MemberDto();
			PropertyCopyUtil.copy(member, memberDto);
			memberDto.setFamilyName(family.getFamilyName());
			listDto.add(memberDto);
		}
		//查询客户列表总记录数
		Integer count = memberMapper.selectCounts();
		//创建Page返回对象
		Page<MemberDto> result = new Page<>();
		result.setPage(page);
		result.setRows(listDto);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}
	
	@Override
	public Page<MemberDto> selectPageWhere(Integer page, Integer rows, MemberDto memberDto) {
		
		String familyName = memberDto.getFamilyName();
		if(familyName != ""){
			Family selectByName = familyMapper.selectByName(familyName);
			int familyId = selectByName.getFamilyId();
			memberDto.setFamilyId(familyId);
		}
			
		memberDto.setStart((page-1) * rows);
		memberDto.setRows(rows);
		//limit查询
		List<Member> members = memberMapper.selectPageWhere(memberDto);
		List<MemberDto> listDto = new ArrayList<MemberDto>();
		for (Member member : members) {
			MemberDto memberListDto = new MemberDto();
			PropertyCopyUtil.copy(member, memberListDto);
			memberListDto.setFamilyName(familyName);
			listDto.add(memberListDto);
		}
		//创建Page返回对象
		Page<MemberDto> result = new Page<>();
		result.setPage(page);
		result.setRows(listDto);
		result.setSize(rows);
		result.setTotal(listDto.size());
		return result;
	}
	

	@Override
	public List<Family> selectFamily() {
		return familyMapper.selectAll();
	}

	@Override
	public Member selectById(int id) {
		Member member = null;
		// 查询数据时，先从缓存查询，有就直接返回 
		 try {  
	        String json = JedisUtils.get("member_"+id);
	        if (!StringUtils.isEmpty(json)) { 
	        	System.out.println("缓存中有数据");
	        	//把json转换成对象
	        	member = JsonUtils.jsonToPojo(json,Member.class);
	        	return member;
	        } else{
	        	// 如果没有则查询数据库  
	        	member = memberMapper.selectById(id);
	        	// 查询之后再放入缓存  
	            try {  
	            	String objectToJson = JsonUtils.objectToJson(member);
	            	JedisUtils.set("member_"+id, objectToJson, 0);
	            	System.out.println("添加缓存。。。。。。。。。。。。。。。。");
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            } 
	        } 
	    } catch (Exception e1) {  
	        e1.printStackTrace();  
	    }
		return member;  
	}

	@Override
	public void addmember(MemberDto memberDto) {
		Family family = familyMapper.selectByName(memberDto.getFamilyName());
		memberDto.setFamilyId(family.getFamilyId());
		memberDto.setMemAddress(memberDto.getProvinceName()+memberDto.getCityName()+memberDto.getAreaName()+memberDto.getTownName());
		Pcat pcat = new Pcat();
		Member member = new Member();
		PropertyCopyUtil.copy(memberDto, pcat);
		PropertyCopyUtil.copy(memberDto, member);
		memberMapper.insert(member); 
		pcat.setMemId(member.getMemId());
		System.out.println(member.getMemId());
		pcatMapper.insert(pcat);
	}

	

	@Override
	public void updatemember(MemberDto memberDto) {
		Pcat pcat = new Pcat();
		Member member = new Member();
		Family family =new Family();
		PropertyCopyUtil.copy(memberDto, pcat);
		//pcat.setId(memberDto.getPcatId());
		PropertyCopyUtil.copy(memberDto, member);
		PropertyCopyUtil.copy(memberDto, family);
		memberMapper.update(member);
		familyMapper.update(family);
		pcatMapper.update(pcat);
		JedisUtils.del("member_"+memberDto.getMemId());
		System.out.println("有更新操作！清除"+"member_"+memberDto.getMemId()+"缓存！！！！");
	}

	@Override
	public Pcat selectPcatById(int memId) {
		Pcat selectById = pcatMapper.selectById(memId);
		return selectById;
	}

	@Override
	public Family selectFamilyById(int familyId) {
		
		return familyMapper.selectById(familyId);
	}

	

	@Override
	public void deletemember(Integer id) {
		memberMapper.deleteById(id);
	}

	@Override
	public void fileUpload(FileDemo fileDemo) {
		fileDemoMapper.insert(fileDemo);
		JedisUtils.del("fileList-"+fileDemo.getPicPrefix());
		System.out.println("有图片上传操作。清除缓存！！！！！");
	}
	
	@Override
	public List<FileDemo> findFileList(String picPrefix) {
		List<FileDemo> fileList = null;
		try {
			String json = JedisUtils.get("fileList-"+picPrefix);
			if(!StringUtils.isEmpty(json)){
				System.out.println("缓存中有数据，获取缓存数据！！！！！");
				fileList = JsonUtils.jsonToList(json, FileDemo.class);
				return fileList;
			}else{
				fileList = fileDemoMapper.selectByPrefix(picPrefix);
				String objectToJson = JsonUtils.objectToJson(fileList);
				JedisUtils.set("fileList-"+picPrefix, objectToJson, 0);
				System.out.println("添加缓存！！！！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileList;
	}
	
	@Override
	public Family findFamilyLocation(String picPrefix) {
		return familyMapper.selectByName(picPrefix);
	}

	@Override
	public List<MemberDto> findList() {
		List<Member> selectAll = memberMapper.selectAll();
		List<MemberDto> listDto = new ArrayList<MemberDto>();
		for (Member member : selectAll) {
			Family selectById = familyMapper.selectById(member.getFamilyId());
			MemberDto memberListDto = new MemberDto();
			PropertyCopyUtil.copy(member, memberListDto);
			memberListDto.setFamilyName(selectById.getFamilyName());
			listDto.add(memberListDto);
		}
		return listDto;
	}

	@Override
	public List<FileDemo> findAll() {
		return fileDemoMapper.selectAll();
	}



}
