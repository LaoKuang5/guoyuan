package cn.edu.glut.action.manger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.glut.component.service.CommodityService;
import cn.edu.glut.model.Commodity;
import cn.edu.glut.util.ServerResponse;

/**
 * 后台商品管理action
 * @author Kuang
 *
 */
@Controller
@RequestMapping("/manager/commodity")
public class CommodityManageAction {
	
	@Autowired
	private CommodityService commodityService;	
	//后期要删除，现在用作跳转做测
	@RequestMapping("/skipCommoditysave")
	public String skipCommoditySavePage() {
		return "editCommodity";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse saveCommoditys(Commodity commodity,String detail,String photos) {		
		ServerResponse response = commodityService.saveCommodity(commodity, detail, photos);
		return response;
	}
	

}
