package cn.itcast.core.dao;

import java.util.List;

import cn.itcast.core.bean.entity.Family;

public interface FamilyMapper {

	List<Family> selectAll();

	Family selectById(int familyId);

	Family selectByName(String familyName);

	void update(Family family);

}
