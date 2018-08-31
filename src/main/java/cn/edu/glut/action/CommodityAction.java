package cn.edu.glut.action;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.edu.glut.component.service.CommodityService;
import cn.edu.glut.model.CommodityDetailVo;
import cn.edu.glut.model.CommodityListVo;
import cn.edu.glut.util.ServerResponse;

@Controller
@RequestMapping("/commodity")
public class CommodityAction {
	
	@Resource(name="commodityService")
	private CommodityService commodityService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String showCommoditys(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
            					@RequestParam(value = "pageSize",defaultValue = "3") int pageSize, Model model) {
		PageInfo<CommodityListVo> commodtiypageInfo = commodityService.getCommodityList(pageNum, pageSize);
		model.addAttribute("commodtiypageInfo", commodtiypageInfo);
		System.out.println(commodtiypageInfo);
		return "commodityList";
	}
	
	@RequestMapping(value="/showCommodity",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse<CommodityDetailVo> showCommodityById(Long commodityId) {
		ServerResponse<CommodityDetailVo> commodityDetailRes= commodityService.getCommodityDetailById(commodityId);
		return commodityDetailRes;
	}
	
	


}
