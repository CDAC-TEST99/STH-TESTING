package hisglobal.FormFlowX.vo;

import hisglobal.vo.ValueObject;

public class FormFlowXUserVO extends ValueObject
{
	public FormFlowXUserVO(){
		
	}
	
	public FormFlowXUserVO(String hospitalCode,String seatId, String userName, String userEmpID,String stateCode,String districtCode ){
		
		this.userName=userName;
		this.seatId =seatId;		
		this.hospitalCode=hospitalCode;
		this.userEmpID=userEmpID;
		this.stateCode=stateCode;
		this.districtCode=districtCode;
		
	//	System.out.println("setting DashboardUserVO \n ==============+ hospitalCode="+ hospitalCode +"\nseatId="+ seatId+"\nstateCode="+ stateCode+  "\n districtCode="+ districtCode);
	}
	


	
	
	
	//private String userId;
	private String userName;
	private String seatId;// contains userid
	private String userEmpID;
	private String hospitalCode;
	private String stateCode;
	private String districtCode;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getUserEmpID() {
		return userEmpID;
	}
	public void setUserEmpID(String userEmpID) {
		this.userEmpID = userEmpID;
	}
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	
	
	
	
}
