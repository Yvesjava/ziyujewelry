package ziyujewelry.com.pojo;


/**
 * 该POJO类对应为镶嵌mosaic表
 * 提供了get，set，toString，无参构造方法
 * @author Administrator
 *
 */
public class Mosaic {
	private Integer mosId;
	private String mosName;
	private String mosMater;
	private Double mosMaterCost;
	private String mosShop;
	private String mosType;
	private Boolean isSelfControl;
	private Double mosControlCost;
	private String mosDesc;
	public Integer getMosId() {
		return mosId;
	}
	public void setMosId(Integer mosId) {
		this.mosId = mosId;
	}
	public String getMosName() {
		return mosName;
	}
	public void setMosName(String mosName) {
		this.mosName = mosName;
	}
	public String getMosMater() {
		return mosMater;
	}
	public void setMosMater(String mosMater) {
		this.mosMater = mosMater;
	}
	public Double getMosMaterCost() {
		return mosMaterCost;
	}
	public void setMosMaterCost(Double mosMaterCost) {
		this.mosMaterCost = mosMaterCost;
	}
	public String getMosShop() {
		return mosShop;
	}
	public void setMosShop(String mosShop) {
		this.mosShop = mosShop;
	}
	public String getMosType() {
		return mosType;
	}
	public void setMosType(String mosType) {
		this.mosType = mosType;
	}
	public Boolean getIsSelfControl() {
		return isSelfControl;
	}
	public void setIsSelfControl(Boolean isSelfControl) {
		this.isSelfControl = isSelfControl;
	}
	public Double getMosControlCost() {
		return mosControlCost;
	}
	public void setMosControlCost(Double mosControlCost) {
		this.mosControlCost = mosControlCost;
	}
	public String getMosDesc() {
		return mosDesc;
	}
	public void setMosDesc(String mosDesc) {
		this.mosDesc = mosDesc;
	}
	
	@Override
	public String toString() {
		return "Mosaic [mosId=" + mosId + ", mosName=" + mosName + ", mosMater=" + mosMater + ", mosMaterCost="
				+ mosMaterCost + ", mosShop=" + mosShop + ", mosType=" + mosType + ", isSelfControl=" + isSelfControl
				+ ", mosControlCost=" + mosControlCost + ", mosDesc=" + mosDesc + "]";
	}
	//无参构造
	public Mosaic() {}
	
}
