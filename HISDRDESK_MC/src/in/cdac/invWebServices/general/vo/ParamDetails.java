package in.cdac.invWebServices.general.vo;

public class ParamDetails {

	private String parameterCode;
	private String parameterName;
	private String value;
	private String standardRange;
	private String reqDNo;
	private String hospCode;
	
	
	
	public ParamDetails(String parameterName, String value, String standardRange, String parameterCode) {
		super();
		//this.hospCode=hospCode;
		//this.reqDNo=reqDNo;
		this.parameterCode = parameterCode;
		this.parameterName = parameterName;
		this.value = value;
		this.standardRange = standardRange;
	}
	
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getStandardRange() {
		return standardRange;
	}
	public void setStandardRange(String standardRange) {
		this.standardRange = standardRange;
	}

	public String getParameterCode() {
		return parameterCode;
	}

	public void setParameterCode(String parameterCode) {
		this.parameterCode = parameterCode;
	}

	
	public String getReqDNo() {
		return reqDNo;
	}

	public void setReqDNo(String reqDNo) {
		this.reqDNo = reqDNo;
	}


	public String getHospCode() {
		return hospCode;
	}

	public void setHospCode(String hospCode) {
		this.hospCode = hospCode;
	}

	
	
}
