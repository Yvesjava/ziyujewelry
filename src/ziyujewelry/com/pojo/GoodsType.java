package ziyujewelry.com.pojo;


/**
 * 该pojo类为商品类型表，比如该商品是不是耳饰或颈饰，或手饰
 * 为每个成员提供了getters和setter和toString和无参构造方法
 * @author Administrator
 *
 */
public class GoodsType {
	private Integer goodsTypeId;
	private String goodsTypeName;
	private String goodsTypeDesc;
	public Integer getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public String getGoodsTypeName() {
		return goodsTypeName;
	}
	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}
	public String getGoodsTypeDesc() {
		return goodsTypeDesc;
	}
	public void setGoodsTypeDesc(String goodsTypeDesc) {
		this.goodsTypeDesc = goodsTypeDesc;
	}
	
	//无参构造
	public GoodsType() {}
	
	@Override
	public String toString() {
		return "GoodsType [goodsTypeId=" + goodsTypeId + ", goodsTypeName=" + goodsTypeName + ", goodsTypeDesc="
				+ goodsTypeDesc + "]";
	}
	
	
}
