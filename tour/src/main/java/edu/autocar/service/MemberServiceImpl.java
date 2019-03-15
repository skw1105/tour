package edu.autocar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.autocar.dao.MemberDao;
import edu.autocar.domain.Member;
import edu.autocar.domain.PageInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao dao;
	
	final static private int PER_PAGE_COUNT = 10;
	
	@Override
	public PageInfo<Member> getPage(int page) throws Exception {
		int start = (page - 1) * PER_PAGE_COUNT;
		int end = start + PER_PAGE_COUNT;

		int totalCount = dao.count(); //boardList.size();
		List<Member> list = dao.getPage(start, end);
		
		System.out.println("start: " + start + ", end: " + end + ", totalCount: ");

		return new PageInfo<>(totalCount,
				(int) Math.ceil(totalCount / (double) PER_PAGE_COUNT),
				page, PER_PAGE_COUNT, list);
	}

	@Override
	@Transactional
	public Member getMember(int userId) throws Exception {
		return dao.findById(userId);
	}

	@Override
	@Transactional
	public void create(Member member) throws Exception {
		dao.insert(member);
	}

	@Override
	@Transactional
	public boolean update(Member member) throws Exception {
		return dao.update(member) == 1;
	}

	@Override
	@Transactional
	public boolean delete(int userId, String password) throws Exception {
		return dao.delete(userId, password) == 1;
	}

}
