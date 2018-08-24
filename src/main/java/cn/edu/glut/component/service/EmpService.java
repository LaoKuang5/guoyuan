package cn.edu.glut.component.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.edu.glut.model.Emp;

@Service(value="empService")
public interface EmpService {
	List<Emp> getAll();
}
