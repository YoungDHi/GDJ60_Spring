package com.iu.s1.board.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.board.FileDTO;
import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		pager.makeRow();
		
		pager.makeNum(qnaDAO.getTotalCount(pager));
		
		return qnaDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile [] files) throws Exception {
		int result = qnaDAO.setBoardAdd(bbsDTO);
		if(files.length!=0) {
			for(MultipartFile file:files) {
				String realPath = servletContext.getRealPath("resources/upload/qna");
				System.out.println(realPath);
				String fileName = fileManager.fileSave(file, realPath);
				FileDTO fileDTO = new FileDTO();
				fileDTO.setFileName(fileName);
				fileDTO.setNum(bbsDTO.getNum());
				fileDTO.setOriName(file.getOriginalFilename());
				
				result = qnaDAO.setFileAdd(fileDTO);
			}
		}	
		return result;
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getBoardDetail(boardDTO);
	}
	
	//reply insert
	public int setReplyAdd(QnaDTO qnaDTO) throws Exception {
		//QnaDTO
		//num : 부모의 글번호
		//writer, title, contents : 답글로 입력한 값
		//ref : null
		//step : null
		//depth : null
		//1. 부모의 정보를 조회
		QnaDTO parent = (QnaDTO)qnaDAO.getBoardDetail(qnaDTO);
		
		//ref : 부모의 ref
		qnaDTO.setRef(parent.getRef());
		
		//step : 부모의 step+1
		qnaDTO.setStep(parent.getStep()+1);
		
		//depth : 부모의 depth+1
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//2. Step update
		int result = qnaDAO.setStepUpdate(parent);
		
		//3. 답글 insert
		result = qnaDAO.setReplyAdd(qnaDTO);
		
		return result;
		
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
