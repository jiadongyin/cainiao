package cn.itcast.core.dao;

import java.util.List;

import javax.management.relation.Role;

import org.apache.ibatis.annotations.Param;

import cn.itcast.core.bean.entity.SysUser;

public interface SysUserMapper {
    //新增
    public Long insert(SysUser SysUser);

    //更新
    public void update(SysUser SysUser);

    //通过对象进行查询
    public SysUser select(SysUser SysUser);

    //通过id进行查询
    public SysUser selectById(int id);

    //查询全部
    public List<SysUser> selectAll(@Param("sort") String sort, @Param("order") String order, @Param("loginName") String loginName, @Param("zhName") String zhName, @Param("email") String email, @Param("phone") String phone, @Param("address") String address);

    //查询数量
    public int selectCounts();

    boolean selectByLoginName(@Param("loginName") String loginName);

    void deleteById(@Param("id") long id);

    boolean isExistLoginNameExcludeId(@Param("id") long id, @Param("loginName") String loginName);

    SysUser selectUserByLoginName(String loginName);

	public SysUser findByName(String username);

	public Role fingRole(Long id);
}