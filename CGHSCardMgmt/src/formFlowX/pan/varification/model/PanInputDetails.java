package formFlowX.pan.varification.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PanInputDetails {

	private String Pan;
	private String Name;
	private LocalDate Dob;
	
	
}
