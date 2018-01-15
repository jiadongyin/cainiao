package cn.itcast.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.itcast.core.bean.entity.SysRole;

public interface SysRoleMapper {
    //新增
    public int insert(SysRole SysRole);

    //更新
    public void update(SysRole SysRole);

    //通过对象进行查询
    public SysRole select(SysRole SysRole);

    //通过id进行查询
    public SysRole selectById(@Param("id") int id);

    //查询全部
    public List<SysRole> selectAll();

    //查询数量
    public int selectCounts();

    boolean isExsitName(@Param("name") String name);

}