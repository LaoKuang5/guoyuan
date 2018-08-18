package guoyuan;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.glut.component.service.EmpService;
import cn.edu.glut.component.service.impl.EmpServiceImpl;
import cn.edu.glut.model.Emp;
@ContextConfiguration("/spring-common.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestApp {
	@Resource
	EmpServiceImpl es;
	@Test
	public void test() {
		List<Emp> emps=es.getAll();
		for (Emp emp : emps) {
			System.out.println(emp.getEname());
		}
	}
}
