package org.zerock.board.service;

import java.util.List;

import org.zerock.board.domain.Board;
import org.zerock.board.dto.BoardDTO;
import org.zerock.common.dto.PageDTO;

public interface BoardService {
	
	List<BoardDTO> getPageList(PageDTO pageDTO);
	
	int getTotalCount();
	
	void register(BoardDTO BoardDTO);

	default Board toDomain(BoardDTO dto) {

		return Board.builder().bno(dto.getBno()).title(dto.getTitle()).content(dto.getContent()).writer(dto.getWriter())
				.redate(dto.getRegdate()).updateDate(dto.getUpdateDate()).build();

	}
}
