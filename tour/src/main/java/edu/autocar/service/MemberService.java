package edu.autocar.service;

import edu.autocar.domain.Member;
import edu.autocar.domain.PageInfo;

public interface MemberService {
	PageInfo<Member> getPage(int page) throws Exception;

	Member getMember(int userId) throws Exception;

	void create(Member member) throws Exception;

	boolean update(Member member) throws Exception;

	boolean delete(int userId, String password) throws Exception;
}
