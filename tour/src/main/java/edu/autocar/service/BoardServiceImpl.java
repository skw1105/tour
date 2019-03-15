package edu.autocar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.autocar.dao.BoardDao;
import edu.autocar.domain.Board;
import edu.autocar.domain.PageInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;
	
	final static private int PER_PAGE_COUNT = 10;

	@Override
	public PageInfo<Board> getPage(int page) throws Exception {
		int start = (page - 1) * PER_PAGE_COUNT;
		int end = start + PER_PAGE_COUNT;

		int totalCount = dao.count(); //boardList.size();
		List<Board> list = dao.getPage(start, end);

		return new PageInfo<>(totalCount,
				(int) Math.ceil(totalCount / (double) PER_PAGE_COUNT),
				page, PER_PAGE_COUNT, list);
	}

	@Override
	@Transactional
	public Board getBoard(int boardId) throws Exception {
		dao.increaseReadCnt(boardId); // 조회수 증가
		return dao.findById(boardId);
	}

	@Override
	@Transactional // 런타임  Exception만 처리해주기 때문에
	public void create(Board board) throws Exception {
		dao.insert(board);
		
		//throw new Exception("게시글 등록 실패"); // 그냥 Exception은 일어나도 롤백이 되지 않는다.
		//throw new RuntimeException("게시글 등록 실패");
		
//		board.setBoardId(maxId);
//		board.setRegDate(new Date());
//		board.setUpdateDate(new Date());
//		maxId++;
//		boardList.add(0, board);
	}

	@Override
	@Transactional
	public boolean update(Board board) throws Exception {
		return dao.update(board) == 1;
	}

	@Override
	@Transactional
	public boolean delete(int boardId, String password) throws Exception {
		return dao.delete(boardId, password) == 1;
	}

}
