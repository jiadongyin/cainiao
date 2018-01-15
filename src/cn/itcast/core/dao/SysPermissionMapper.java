package cn.itcast.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.itcast.core.bean.entity.SysPermission;

public interface SysPermissionMapper {
    //新增
    public Long insert(SysPermission SysPermission);

    //更新
    public void update(SysPermission SysPermission);

    //通过对象进行查询
    public SysPermission select(SysPermission SysPermission);

    //通过id进行查询
    public List<SysPermission> selectById(int id);

    //查询全部
    public List<SysPermission> selectAll();

    //查询数量
    public int selectCounts();

    boolean isExistName(@Param("name") String name);

}