package guoyuan;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.portlet.MockActionRequest;
import org.springframework.mock.web.portlet.MockActionResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.org.apache.regexp.internal.recompile;

import cn.edu.glut.action.UserAction;
import cn.edu.glut.component.dao.UserDao;
import cn.edu.glut.model.UserInfo;
@ContextConfiguration("/spring-common.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestApp {
	
	
	@Resource
	UserDao u;
	@Resource
	ComboPooledDataSource dataSource;
	Logger log=LogManager.getLogger(this.getClass());
	UserAction userAction ;
	@Test
	public void test() {
	}
	
	
}
