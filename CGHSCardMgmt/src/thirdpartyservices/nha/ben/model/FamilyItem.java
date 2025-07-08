package thirdpartyservices.nha.ben.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "hhid", "scode", "bentype", "hhdtype", "stateName", "familyMember" })
public class FamilyItem{
	private List<FamilyMemberItem> familyMember;
	private String scode;
	private String bentype;
	private String stateName;
	private String hhdtype;
	private String hhid;

	public List<FamilyMemberItem> getFamilyMember(){
		return familyMember;
	}

	public String getScode(){
		return scode;
	}

	public String getBentype(){
		return bentype;
	}

	public String getStateName(){
		return stateName;
	}

	public String getHhdtype(){
		return hhdtype;
	}

	public String getHhid(){
		return hhid;
	}
}