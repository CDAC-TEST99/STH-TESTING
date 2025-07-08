package thirdpartyservices.nha.ben.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NHABenRequest{
	private String hmac;
	private String errorCode;
	private BeneficiaryDetails beneficiaryDetails;
	private String token;

	public String getHmac(){
		return hmac;
	}

	public String getErrorCode(){
		return errorCode;
	}

	public BeneficiaryDetails getBeneficiaryDetails(){
		return beneficiaryDetails;
	}

	public String getToken(){
		return token;
	}
}
