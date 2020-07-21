package api;


import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class part {
	
	
	private Integer ID;
	private String brand;
	private String car;
	private Date pdate;
	private Integer paction;
	private Integer pvalue;
	private Integer pvisible;
	private Integer discount;
	
	@Id
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public Integer getPaction() {
		return paction;
	}
	public void setPaction(Integer paction) {
		this.paction = paction;
	}
	public Integer getPvalue() {
		return pvalue;
	}
	public void setPvalue(Integer pvalue) {
		this.pvalue = pvalue;
	}
	public Integer getPvisible() {
		return pvisible;
	}
	public void setPvisible(Integer pvisible) {
		this.pvisible = pvisible;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
}
