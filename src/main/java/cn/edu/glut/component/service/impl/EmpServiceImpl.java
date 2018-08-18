package cn.edu.glut.component.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.glut.component.dao.EmpDao;
import cn.edu.glut.component.service.EmpService;
import cn.edu.glut.model.Emp;

//beanID    ↓
@Service("empService")
public class EmpServiceImpl implements EmpService{
	@Resource
	EmpDao empDao ;
	@Override
	public List<Emp> getAll() {
		
		return empDao.getAll();
	}
		
}
