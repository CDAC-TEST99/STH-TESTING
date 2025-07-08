package thirdpartyservices.nha.referral.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "status", "responseCode", "responseMessage", "referralId", "beneficiaryDetails", "results" })
public class NHARefResponse{
	private String responseCode;
	private String referralId;
	private BeneficiaryDetails beneficiaryDetails;
	private List<ResultsItem> results;
	private boolean status;
	private String responseMessage;

	@JsonProperty(value = "response_Code")
	public String getResponseCode(){
		return responseCode;
	}

	@JsonProperty(value = "referral_Id")
	public String getReferralId(){
		return referralId;
	}

	@JsonProperty(value = "beneficiary_Details")
	public BeneficiaryDetails getBeneficiaryDetails(){
		return beneficiaryDetails;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public boolean isStatus(){
		return status;
	}

	@JsonProperty(value = "response_Message")
	public String getResponseMessage(){
		return responseMessage;
	}
}