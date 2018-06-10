package ziyujewelry.com.pojo;

public class Goods {
	private Integer goodsId;
	private String goodsSn;
	private String goodsName;
	private String goodsImg;
	private String goodsDesc;
	private String shopName;
	private Integer materId;
	private Integer goodsTypeId;
	private Integer mosId;
	private Double markePrice;
	private Double goodsCost;
	private Integer goodsStock;
	private Integer saleCount;
	private Boolean isHot;
	private Boolean isNew;
	
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsSn() {
		return goodsSn;
	}
	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Integer getMaterId() {
		return materId;
	}
	public void setMaterId(Integer materId) {
		this.materId = materId;
	}
	public Integer getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public Integer getMosId() {
		return mosId;
	}
	public void setMosId(Integer mosId) {
		this.mosId = mosId;
	}
	public Double getMarkePrice() {
		return markePrice;
	}
	public void setMarkePrice(Double markePrice) {
		this.markePrice = markePrice;
	}
	public Double getGoodsCost() {
		return goodsCost;
	}
	public void setGoodsCost(Double goodsCost) {
		this.goodsCost = goodsCost;
	}
	public Integer getGoodsStock() {
		return goodsStock;
	}
	public void setGoodsStock(Integer goodsStock) {
		this.goodsStock = goodsStock;
	}
	public Integer getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}
	public Boolean getIsHot() {
		return isHot;
	}
	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}
	public Boolean getIsNew() {
		return isNew;
	}
	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}
	
	
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsSn=" + goodsSn + ", goodsName=" + goodsName + ", goodsImg="
				+ goodsImg + ", goodsDesc=" + goodsDesc + ", shopName=" + shopName + ", materId=" + materId
				+ ", goodsTypeId=" + goodsTypeId + ", mosId=" + mosId + ", markePrice=" + markePrice + ", goodsCost="
				+ goodsCost + ", goodsStock=" + goodsStock + ", saleCount=" + saleCount + ", isHot=" + isHot
				+ ", isNew=" + isNew + ", getGoodsId()=" + getGoodsId() + ", getGoodsSn()=" + getGoodsSn()
				+ ", getGoodsName()=" + getGoodsName() + ", getGoodsImg()=" + getGoodsImg() + ", getGoodsDesc()="
				+ getGoodsDesc() + ", getShopName()=" + getShopName() + ", getMaterId()=" + getMaterId()
				+ ", getGoodsTypeId()=" + getGoodsTypeId() + ", getMosId()=" + getMosId() + ", getMarkePrice()="
				+ getMarkePrice() + ", getGoodsCost()=" + getGoodsCost() + ", getGoodsStock()=" + getGoodsStock()
				+ ", getSaleCount()=" + getSaleCount() + ", getIsHot()=" + getIsHot() + ", getIsNew()=" + getIsNew()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	//无参构造
	public Goods() {}
	
	
	
}
