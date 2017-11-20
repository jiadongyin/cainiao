package cn.itcast.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.redis.JedisUtils;
import cn.itcast.common.utils.JsonUtils;
import cn.itcast.common.utils.Page;
import cn.itcast.common.utils.StringUtils;
import cn.itcast.core.bean.Family;
import cn.itcast.core.bean.FileDemo;
import cn.itcast.core.bean.QueryVo;
import cn.itcast.core.dao.MemberDao;
import cn.itcast.core.service.MemberService;
import redis.clients.jedis.Jedis;

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
//		List<QueryVo> queryVos  = null;
//		// 查询数据时，先从缓存查询，有就直接返回 
//		 try {  
//	        String json = JedisUtils.get("page"+page);
//	        if (!StringUtils.isEmpty(json)) { 
//	        	System.out.println("缓存中有数据");
//	        	//把json转换成list
//	        	queryVos = JsonUtils.jsonToList(json, QueryVo.class);
//	        } else{
//	        	// 如果没有则查询数据库  
//	        	 queryVos = memberDao.selectMemberList(queryVo);
//	        	// 查询之后再放入缓存  
//	            try {
//	            	String objectToJson = JsonUtils.objectToJson(queryVos);
//	            	JedisUtils.set("page"+page, objectToJson, 0);
//	            	System.out.println("添加缓存。。。page"+page+"。。。。。。。。。。。。。");
//	            } catch (Exception e) {  
//	                e.printStackTrace();  
//	            }  
//	        } 
//	    } catch (Exception e1) {  
//	        e1.printStackTrace();  
//	    }  
				 
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
		QueryVo queryVo = null;
		// 查询数据时，先从缓存查询，有就直接返回 
		 try {  
	        String json = JedisUtils.get("member_"+id);
	        if (!StringUtils.isEmpty(json)) { 
	        	System.out.println("缓存中有数据");
	        	//把json转换成对象
	        	queryVo = JsonUtils.jsonToPojo(json,QueryVo.class);
	        	return queryVo;
	        } else{
	        	// 如果没有则查询数据库  
	        	queryVo = memberDao.getmemberById(id);
	        	// 查询之后再放入缓存  
	            try {  
	            	String objectToJson = JsonUtils.objectToJson(queryVo);
	            	JedisUtils.set("member_"+id, objectToJson, 0);
	            	System.out.println("添加缓存。。。。。。。。。。。。。。。。");
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            } 
	        } 
	    } catch (Exception e1) {  
	        e1.printStackTrace();  
	    }
		return queryVo;  
	}

	@Override
	public void updatemember(QueryVo queryVo) {
		memberDao.update(queryVo);
		JedisUtils.del("member_"+queryVo.getMemId());
		System.out.println("有更新操作！清除"+"member_"+queryVo.getMemId()+"缓存！！！！");
	}

	@Override
	public void addmember(QueryVo queryVo) {
		memberDao.add(queryVo);
	}

	@Override
	public void deletemember(Integer id) {
		memberDao.delete(id);
	}

	@Override
	public void fileUpload(FileDemo fileDemo) {
		memberDao.fileUpload(fileDemo);
		JedisUtils.del("fileList");
		System.out.println("有图片上传操作。清除缓存！！！！！");
	}
	
	@Override
	public List<FileDemo> findFileList() {
		List<FileDemo> fileList = null;
		try {
			String json = JedisUtils.get("fileList");
			if(!StringUtils.isEmpty(json)){
				System.out.println("缓存中有数据，获取缓存数据！！！！！");
				fileList = JsonUtils.jsonToList(json, FileDemo.class);
				return fileList;
			}else{
				fileList = memberDao.findFileList();
				String objectToJson = JsonUtils.objectToJson(fileList);
				JedisUtils.set("fileList", objectToJson, 0);
				System.out.println("添加缓存！！！！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileList;
	}

	@Override
	public List<QueryVo> findList(QueryVo queryVo) {
		return memberDao.findList(queryVo);
	}

	

}
