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
@JsonPropertyOrder({ "procedureType", "referralType", "component", "refCityCode", "refStatus", "refHospitalName", "refDocterName", "refDate", "refTime", "refRemarks", "cghsDoctor", "p1formPdf"  })
public class ResultsItem{
	private List<ComponentItem> component;
	private String refTime;
	private String refRemarks;
	private String refStatus;
	private String refDate;
	private String refDocterName;
	private String referralType;
	private String refCityCode;
	private String procedureType;
	private String refHospitalName;
	private String cghsDoctor;

	@JsonProperty(value = "procedure_type")
	public String getProcedureType(){
		return procedureType;
	}

	@JsonProperty(value = "referral_type")
	public String getReferralType(){
		return referralType;
	}

	public List<ComponentItem> getComponent(){
		return component;
	}

	@JsonProperty(value = "ref_city_code")
	public String getRefCityCode(){
		return refCityCode;
	}
	
	@JsonProperty(value = "ref_status")
	public String getRefStatus(){
		return refStatus;
	}

	@JsonProperty(value = "ref_hospital_name")
	public String getRefHospitalName(){
		return refHospitalName;
	}

	@JsonProperty(value = "ref_docter_name")
	public String getRefDocterName(){
		return refDocterName;
	}

	@JsonProperty(value = "ref_date")
	public String getRefDate(){
		return refDate;
	}


	@JsonProperty(value = "ref_time")
	public String getRefTime(){
		return refTime;
	}

	@JsonProperty(value = "ref_remarks")
	public String getRefRemarks(){
		return refRemarks;
	}

	@JsonProperty(value = "cghs_doctor")
	public String getCghsDoctor(){
		return cghsDoctor;
	}
}