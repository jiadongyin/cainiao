package cn.itcast.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.log.annotation.ServiceLog;
import cn.itcast.core.bean.entity.SystemLog;
import cn.itcast.core.dao.SystemLogMapper;
import cn.itcast.core.service.SystemLogService;
@Service("systemLogService")
@Transactional
public class SystemLogServiceImpl implements SystemLogService{

	 @Resource
      private SystemLogMapper systemLogMapper;
      
      @Override
      public int deleteSystemLog(String id) {
         return systemLogMapper.deleteByPrimaryKey(id);
      }
  
      @Override
      @ServiceLog(operationType="insert",operationName="插入日志到数据库")
      public int insert(SystemLog record) {
          return systemLogMapper.insertSelective(record);
      }
  
      @Override
      public SystemLog selectSystemLog(String id) {
          return systemLogMapper.selectByPrimaryKey(id);
      }
  
      @Override
      public int updateSystemLog(SystemLog record) {
          return systemLogMapper.updateByPrimaryKeySelective(record);
      }
  
      @Override
      public int insertTest(SystemLog record) {
         return systemLogMapper.insert(record);
      }
  

}
