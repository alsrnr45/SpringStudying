package com.kh.spring.board.model.service;

import java.util.ArrayList;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.common.model.vo.PageInfo;

public interface BoardService {
	
	// 게시판 리스트 조회(페이징처리)
	int selectListCount();
	
	// 게시판 리스트 조회
	ArrayList<Board> selectList(PageInfo pi);
	
	// 게시판 작성
	int insertBoard(Board b);
	
	// 게시판 상세조회
	int increaseCount(int boardNo);
	Board selectBoard(int boardNo);
	
	// 게시판수정
	int updateBoard(Board b);
	
	// 게시판 삭제
	int deleteBoard(int boardNo);
	
}
