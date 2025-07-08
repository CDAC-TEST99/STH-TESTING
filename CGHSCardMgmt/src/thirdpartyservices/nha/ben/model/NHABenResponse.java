package thirdpartyservices.nha.ben.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "status", "operation", "errorcode", "errorMessage", "header", "familySearchDetails" })
public class NHABenResponse{
	private FamilySearchDetails familySearchDetails;
	private String errorMessage;
	private Header header;
	private String operation;
	private String errorcode;
	private boolean status;

	public FamilySearchDetails getFamilySearchDetails(){
		return familySearchDetails;
	}

	public String getErrorMessage(){
		return errorMessage;
	}

	public Header getHeader(){
		return header;
	}

	public String getOperation(){
		return operation;
	}

	public String getErrorcode(){
		return errorcode;
	}

	public boolean isStatus(){
		return status;
	}
	
	
}
