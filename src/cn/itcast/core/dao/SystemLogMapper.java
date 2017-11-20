package cn.itcast.core.dao;

import cn.itcast.core.bean.SystemLog;

public interface SystemLogMapper {

	 int deleteByPrimaryKey(String id);
 
     int insert(SystemLog record);
 
     int insertSelective(SystemLog record);
 
     SystemLog selectByPrimaryKey(String id);
 
     int updateByPrimaryKeySelective(SystemLog record);
 
     int updateByPrimaryKey(SystemLog record);
}
