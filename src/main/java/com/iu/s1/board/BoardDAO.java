package com.iu.s1.board;

import java.util.List;

import com.iu.s1.util.Pager;

public interface BoardDAO extends BbsDAO {
	
	//list
	
	//detail
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;

	//add
	
	//fileAdd
	public int setBoardFileAdd(BoardFileDTO fileDTO) throws Exception;
	//update
	
	//delete
	
	//boardFileList
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO);

}
