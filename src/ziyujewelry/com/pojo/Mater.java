package ziyujewelry.com.pojo;

public class Mater {
	private Integer materId;
	private String materName;
	private String materShape;
	private String materSize;
	private Double materCost;
	public Integer getMaterId() {
		return materId;
	}
	public void setMaterId(Integer materId) {
		this.materId = materId;
	}
	public String getMaterName() {
		return materName;
	}
	public void setMaterName(String materName) {
		this.materName = materName;
	}
	public String getMaterShape() {
		return materShape;
	}
	public void setMaterShape(String materShape) {
		this.materShape = materShape;
	}
	public String getMaterSize() {
		return materSize;
	}
	public void setMaterSize(String materSize) {
		this.materSize = materSize;
	}
	public Double getMaterCost() {
		return materCost;
	}
	public void setMaterCost(Double materCost) {
		this.materCost = materCost;
	}
	
	@Override
	public String toString() {
		return "Mater [materId=" + materId + ", materName=" + materName + ", materShape=" + materShape + ", materSize="
				+ materSize + ", materCost=" + materCost + "]";
	}
	
	//无参构造
	public Mater() {}
	
	
	
}
