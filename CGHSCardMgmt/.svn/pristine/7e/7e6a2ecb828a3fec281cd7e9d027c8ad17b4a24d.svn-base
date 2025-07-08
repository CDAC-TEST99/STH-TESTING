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
@JsonPropertyOrder({ "refComp", "refCompDetails", "refCompDetailsCode", "refCompRemarks", "refCompQuantity", "refCompValidTo" })
public class ComponentItem{
	private String refCompDetails;
	private String refCompQuantity;
	private String refCompDetailsCode;
	private String refComp;
	private String refCompRemarks;
	private String refCompValidTo;

	@JsonProperty(value = "ref_comp")
	public String getRefComp(){
		return refComp;
	}

	@JsonProperty(value = "ref_comp_details")
	public String getRefCompDetails(){
		return refCompDetails;
	}

	@JsonProperty(value = "ref_comp_quantity")
	public String getRefCompQuantity(){
		return refCompQuantity;
	}

	@JsonProperty(value = "ref_comp_details_code")
	public String getRefCompDetailsCode(){
		return refCompDetailsCode;
	}


	@JsonProperty(value = "ref_comp_remarks")
	public String getRefCompRemarks(){
		return refCompRemarks;
	}

	@JsonProperty(value = "ref_comp_validTo")
	public String getRefCompValidTo(){
		return refCompValidTo;
	}
}
