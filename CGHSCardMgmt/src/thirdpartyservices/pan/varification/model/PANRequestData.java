package thirdpartyservices.pan.varification.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PANRequestData  implements Serializable {

	private static final long serialVersionUID = 1L;
	private String pan;
	private String name;
	private String fathername;
	private String dob;
	
	
}
