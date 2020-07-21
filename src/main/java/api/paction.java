package api;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

 @Entity
public class paction {
	 
	private Integer ID;
	private Date pstart;
	private Date pend;
	private Integer discount;
	
	@Id
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Date getPstart() {
		return pstart;
	}
	public void setPstart(Date pstart) {
		this.pstart = pstart;
	}
	public Date getPend() {
		return pend;
	}
	public void setPend(Date pend) {
		this.pend = pend;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

}
