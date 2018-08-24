package guoyuan;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.glut.component.dao.UserDao;
import cn.edu.glut.component.service.EmpService;
import cn.edu.glut.component.service.impl.EmpServiceImpl;
import cn.edu.glut.model.Emp;
import cn.edu.glut.model.UserInfo;
@ContextConfiguration("/spring-common.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestApp {
	@Resource(name="empService")
	EmpService es;
	@Resource
	UserDao u;
	@Test
	public void test() {
		UserInfo user=new UserInfo();
		user.setTelephone("110");
		u.addUserInfo(user);
		if(user.getUserId()==null) {
			System.out.println(user);
		}
		System.out.println(user.getUserId());
	}
	
	
}
