package cn.edu.glut.component.dao;

import java.util.List;

import cn.edu.glut.model.Commodity;
import cn.edu.glut.model.CommodityListVo;


/**
 *  操作商品信息的dao
 *  @author Kuang
 *
 */
public interface CommodityDao {
	
	/**
	 * 查询所有商品列表信息
	 * @author Kuang
	 */
	List<CommodityListVo> selectCommodityList();
	/**
	 * 插入商品
	 * @param commodity
	 * @author Kuang
	 * @return 
	 */
	int insertCommodity(Commodity commodity); 
	/**
	 * 根据商品id查询商品基本信息
	 * @param commodityId
	 * @author Kuang
	 * @return 
	 */
	Commodity selectCommodityById(Long commodityId);
}
