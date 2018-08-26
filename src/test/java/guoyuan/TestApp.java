package guoyuan;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.edu.glut.component.dao.UserDao;
@ContextConfiguration("/spring-common.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestApp {
	

	@Resource
	UserDao u;
	@Resource
	ComboPooledDataSource dataSource;
	Logger log=LogManager.getLogger(this.getClass());
	
	@Test
	public void test() {
		String a=null;
		log.trace("好困");
		try {
			a.endsWith("");
		}catch (Exception e) {
			log.error("",e);
		}
		
	}
	
	
}
