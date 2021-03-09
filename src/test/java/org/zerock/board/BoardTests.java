package org.zerock.board;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.board.config.BoardConfig;
import org.zerock.board.mapper.BoardMapper;
import org.zerock.board.service.BoardService;
import org.zerock.common.config.CommonConfig;
import org.zerock.common.dto.PageDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CommonConfig.class, BoardConfig.class })
@Log4j
public class BoardTests {

	@Autowired
	BoardMapper mapper;
	
	@Autowired
	BoardService service;
	

	@Test
	public void test1() {

//		boardMapper.getList(10,10).forEach(b -> log.info(b));
		
		
		service.getPageList(PageDTO.builder().build())
		.forEach(dto -> log.info(dto));
		
	}

}
