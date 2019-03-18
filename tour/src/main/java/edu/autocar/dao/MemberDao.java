package edu.autocar.dao;

import org.apache.ibatis.annotations.Param;

import edu.autocar.domain.Member;

public interface MemberDao extends CrudDao<Member, String> {
//	int delete(@Param("userId")String userId,
//			@Param("password")String password) throws Exception;
	int updateByAdmin(Member member) throws Exception;
}
