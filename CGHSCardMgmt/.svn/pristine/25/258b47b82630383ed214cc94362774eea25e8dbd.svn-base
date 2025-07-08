package thirdpartyservices.nha.referral.model;

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
@JsonPropertyOrder({ "benId", "benName", "dispensaryCode", "dispensaryName" })
public class BeneficiaryDetails{
	private String benId;
	private String dispensaryName;
	private String benName;
	private String dispensaryCode;

	@JsonProperty(value = "ben_id")
	public String getBenId(){
		return benId;
	}

	@JsonProperty(value = "dispensary_name")
	public String getDispensaryName(){
		return dispensaryName;
	}

	@JsonProperty(value = "ben_name")
	public String getBenName(){
		return benName;
	}

	@JsonProperty(value = "dispensary_code")
	public String getDispensaryCode(){
		return dispensaryCode;
	}
}
