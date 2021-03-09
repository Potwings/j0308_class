package org.zerock.main.common;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.common.config.CommonConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonConfig.class})
@Log4j
public class ConfigLoadTests {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	
	@Test
	public void test1() {
		log.info("test1...............");
	}
	
	@Test
	public void test2() {
		
		SqlSession session = sqlSessionFactory.openSession();
		log.info(session);

		session.close();
		
	}
	
}
