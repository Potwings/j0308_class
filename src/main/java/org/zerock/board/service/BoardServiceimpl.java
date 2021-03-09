package org.zerock.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.zerock.board.domain.Board;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.mapper.BoardMapper;
import org.zerock.common.dto.PageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class BoardServiceimpl implements BoardService {

	private final BoardMapper mapper;
	
	@Override
	public void register(BoardDTO BoardDTO) {
	
		Board vo = toDomain(BoardDTO);
	
		mapper.insert(vo);
	}
	
	
	
	@Override
	public List<BoardDTO> getPageList(PageDTO pageDTO) {

		
		
	return mapper.getList(pageDTO.getSkip(), pageDTO.getPerSheet())
		.stream().map(board -> {
			BoardDTO dto = new BoardDTO();
			dto.setBno(board.getBno());
			dto.setTitle(board.getTitle());
			dto.setContent(board.getContent());
			dto.setWriter(board.getWriter());
			dto.setRegdate(board.getRedate());
			dto.setUpdateDate(board.getUpdateDate());
			
			return dto;
		}).collect(Collectors.toList());
		
				
	}

	@Override
	public int getTotalCount() {
		
		return mapper.getTotalCount();
	}


}
