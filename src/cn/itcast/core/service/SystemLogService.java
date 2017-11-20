package cn.itcast.core.service;

import cn.itcast.core.bean.SystemLog;

public interface SystemLogService {

	 int deleteSystemLog(String id);
 
     int insert(SystemLog record);
     
     int insertTest(SystemLog record);
 
     SystemLog selectSystemLog(String id);
     
     int updateSystemLog(SystemLog record);
}
