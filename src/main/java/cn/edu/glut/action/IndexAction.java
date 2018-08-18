package cn.edu.glut.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexAction {
	IndexAction(){
		System.out.println("action 构建了");
	}
	@RequestMapping(value="index")
	public String index() {
		return "test";
	}
}
