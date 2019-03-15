package edu.autocar.dao;

import org.apache.ibatis.annotations.Param;

import edu.autocar.domain.Member;

public interface MemberDao extends CrudDao<Member, Integer> {
	int delete(@Param("userId")Integer userId,
			@Param("password")String password) throws Exception;
}
