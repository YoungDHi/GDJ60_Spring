package com.iu.s1.board;

import java.util.List;

import com.iu.s1.util.Pager;

public interface BoardDAO extends BbsDAO {
	
	//list
	
	//detail
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;

	//add
	public int setFileAdd(FileDTO fileDTO) throws Exception;
	//update
	
	//delete

}
