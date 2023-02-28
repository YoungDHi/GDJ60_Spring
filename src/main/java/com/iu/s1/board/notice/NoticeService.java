package com.iu.s1.board.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	

	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		pager.makeRow();
		
		pager.makeNum(noticeDAO.getTotalCount(pager));
		
		return noticeDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile[] files, HttpSession session) throws Exception {
		int result = noticeDAO.setBoardAdd(bbsDTO);
		for(MultipartFile file:files) {
			if(file.isEmpty()) {
				continue;
			}			
			String realPath = servletContext.getRealPath("resources/upload/notice/");
			System.out.println(realPath);
			String fileName = fileManager.fileSave(file, realPath);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setNum(bbsDTO.getNum());
			boardFileDTO.setOriName(file.getOriginalFilename());
				
			result = noticeDAO.setBoardFileAdd(boardFileDTO);
		}
		return result;
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		List<BoardFileDTO> ar = noticeDAO.getBoardFileList(bbsDTO);
		int result = noticeDAO.setBoardDelete(bbsDTO);
		
		
		if(result>=0) {
			String realPath = session.getServletContext().getRealPath("resources/upload/notice/");
			for(BoardFileDTO boardFileDTO:ar) {
				boolean check = fileManager.fileDelete(realPath, boardFileDTO.getFileName());
			}
		}
		
		return result;
	}

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getBoardDetail(boardDTO);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) {
		// TODO Auto-generated method stub
		return noticeDAO.getBoardFileDetail(boardFileDTO);
	}

}
