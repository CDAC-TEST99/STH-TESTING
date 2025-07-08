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
@JsonPropertyOrder({ "rationCard", "stateCode" })
public class RationCardDetails{
	private String rationCard;
	private int stateCode;

	public String getRationCard(){
		return rationCard;
	}

	public int getStateCode(){
		return stateCode;
	}
}
