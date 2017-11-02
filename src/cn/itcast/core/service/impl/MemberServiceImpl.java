package cn.itcast.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.utils.Page;
import cn.itcast.core.bean.Family;
import cn.itcast.core.bean.FileDemo;
import cn.itcast.core.bean.Member;
import cn.itcast.core.bean.QueryVo;
import cn.itcast.core.dao.MemberDao;
import cn.itcast.core.service.MemberService;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {
	
	// 定义dao属性
	@Autowired
	private MemberDao memberDao;

	@Override
	public Page<QueryVo> findMemberList(Integer page, Integer rows, QueryVo queryVo) {
		//当前页
		queryVo.setStart((page-1) * rows) ;
		//每页数
		queryVo.setRows(rows);
		//查询客户列表
		List<QueryVo> queryVos = memberDao.selectMemberList(queryVo);
		//查询客户列表总记录数
		Integer count = memberDao.selectMemberListCount(queryVo);
		//创建Page返回对象
		Page<QueryVo> result = new Page<>();
		result.setPage(page);
		result.setRows(queryVos);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}

	@Override
	public List<Family> selectFamily() {
		
		return memberDao.selectFamily();
	}



	@Override
	public QueryVo getmemberById(int id) {
		return memberDao.getmemberById(id);
	}

	@Override
	public void updatemember(QueryVo queryVo) {
		memberDao.update(queryVo);
	}

	@Override
	public int addmember(QueryVo queryVo) {
		
		return memberDao.add(queryVo);
	}

	@Override
	public void deletemember(Integer id) {
		memberDao.delete(id);
	}

	@Override
	public void fileUpload(FileDemo fileDemo) {
		memberDao.fileUpload(fileDemo);
		
	}
	
	@Override
	public List<FileDemo> findFileList() {
		
		return memberDao.findFileList();
	}

	

}
