package thirdpartyservices.nha.ben.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FamilySearchDetails{
	private List<FamilyItem> family;

	public List<FamilyItem> getFamily(){
		return family;
	}
}