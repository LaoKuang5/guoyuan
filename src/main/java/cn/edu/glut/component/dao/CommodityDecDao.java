package cn.edu.glut.component.dao;

import cn.edu.glut.model.CommodityDec;

/**
 * 商品描述dao
 * @author Kuang
 *
 */
public interface CommodityDecDao {
	
	/**
	 * 插入商品描述
	 * @param commodityDec
	 * @return 插入记录数
	 * @author Kuang
	 */
	int insertCommodityDec(CommodityDec commodityDec);
	/**
	 * 根据id查询商品描述信息
	 * @param commodityId
	 * @return 商品描述
	 * @author Kuang
	 */
	String selectCommodityDecById(Long commodityId);
	

}
