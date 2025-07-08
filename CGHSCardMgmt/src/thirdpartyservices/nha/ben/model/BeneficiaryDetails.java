package thirdpartyservices.nha.ben.model;

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
@JsonPropertyOrder({ "ahlTinId", "uuid", "hhId", "mobileNumber", "aadharToken", "rationCardDetails", "familyType", "healthId" })
public class BeneficiaryDetails{
	private String healthId;
	private String familyType;
	private String mobileNumber;
	private String ahlTinId;
	private String hhId;
	private String uuid;
	private String aadharToken;
	private RationCardDetails rationCardDetails;

	@JsonProperty(value = "health_id")
	public String getHealthId(){
		return healthId;
	}

	public String getFamilyType(){
		return familyType;
	}

	public String getMobileNumber(){
		return mobileNumber;
	}

	public String getAhlTinId(){
		return ahlTinId;
	}

	public String getHhId(){
		return hhId;
	}

	public String getUuid(){
		return uuid;
	}

	public String getAadharToken(){
		return aadharToken;
	}

	public RationCardDetails getRationCardDetails(){
		return rationCardDetails;
	}
}
