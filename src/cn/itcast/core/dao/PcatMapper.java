package cn.itcast.core.dao;

import java.util.List;

import cn.itcast.core.bean.dto.MemberDto;
import cn.itcast.core.bean.entity.Member;
import cn.itcast.core.bean.entity.Pcat;

public interface PcatMapper {

	void insert(Pcat pcat);

	Pcat selectById(int memId);

	void update(Pcat pcat);

	

}
