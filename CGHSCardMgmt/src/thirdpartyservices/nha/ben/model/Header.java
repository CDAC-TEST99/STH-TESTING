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
@JsonPropertyOrder({ "errorCode", "version", "beneficiaryDetails" })
public class Header{
	private String errorCode;
	private BeneficiaryDetails beneficiaryDetails;
	private String version;

	public String getErrorCode(){
		return errorCode;
	}

	public BeneficiaryDetails getBeneficiaryDetails(){
		return beneficiaryDetails;
	}

	public String getVersion(){
		return version;
	}
}
