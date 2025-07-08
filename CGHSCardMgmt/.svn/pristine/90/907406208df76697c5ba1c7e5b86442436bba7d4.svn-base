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
@JsonPropertyOrder({ "statelgdCode", "benstatelgdCode", "districtlgdCode", "SubdistrictlgdCode", "bendistrictlgdCode", "address", "villageTownlgdCode", "ruralUrban", "pinCode" })
public class Address{
	private String bendistrictlgdCode;
	private String address;
	private String ruralUrban;
	private String statelgdCode;
	private String pinCode;
	private String districtlgdCode;
	private String benstatelgdCode;
	private String subdistrictlgdCode;
	private String villageTownlgdCode;

	public String getBendistrictlgdCode(){
		return bendistrictlgdCode;
	}

	public String getAddress(){
		return address;
	}

	public String getRuralUrban(){
		return ruralUrban;
	}

	public String getStatelgdCode(){
		return statelgdCode;
	}

	public String getPinCode(){
		return pinCode;
	}

	public String getDistrictlgdCode(){
		return districtlgdCode;
	}

	public String getBenstatelgdCode(){
		return benstatelgdCode;
	}

	public String getSubdistrictlgdCode(){
		return subdistrictlgdCode;
	}

	
	@JsonProperty(value = "village_townlgdCode")
	public String getVillageTownlgdCode(){
		return villageTownlgdCode;
	}
}
