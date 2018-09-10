/**
 * <p>
 * Consist of all the details regarding the ward which contains bed number and 
 * status of the bed which represents whether they are allocated, free or under
 * maintaince.
 * </p>
 * @author Harish
 *
 */
public class Ward {
    
	private Integer wardNumber;
	private Integer bedNumber;
	private String status;
	private Integer visitId;
		
	public Integer getWardNumber() {
		return wardNumber;
	}
	public void setWardNumber(Integer wardNumber) {
		this.wardNumber = wardNumber;
	}
	public Integer getBedNumber() {
		return bedNumber;
	}
	public void setBedNumber(Integer bedNumber) {
		this.bedNumber = bedNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getVisitId() {
		return visitId;
	}
	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}
	
}
