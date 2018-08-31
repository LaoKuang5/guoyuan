package cn.edu.glut.model;
/**
 * 商品描述
 * @author Kuang
 *
 */
public class CommodityDec {
	
    private Long commodityId;
    private String commodityDesc;   //商品详细描述
	public Long getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}
	public String getCommodityDesc() {
		return commodityDesc;
	}
	public void setCommodityDesc(String commodityDesc) {
		this.commodityDesc = commodityDesc;
	}
}
